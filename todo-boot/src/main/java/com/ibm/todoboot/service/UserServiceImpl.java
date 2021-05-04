package com.ibm.todoboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.todoboot.POJO.Login;
import com.ibm.todoboot.entity.ToDo;
import com.ibm.todoboot.entity.User;
import com.ibm.todoboot.repository.ToDoRepo;
import com.ibm.todoboot.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo ur;
	@Autowired 
	private ToDoRepo tr;
	
	@Override
	public int addUser(User user) {
		ur.save(user);
		return user.getUserId();
	}

	@Override
	public int addTaskToUser(int userId, int id) {
		User user = ur.findById(userId).get();
		ToDo task = tr.findById(id).get();
		task.setUsers(user);
		tr.save(task);
		return user.getUserId();
	}

	@Override
	public User authenticate(Login login) {
		return ur.findByNameAndPassword(login.getUname(), login.getPassword()).orElseThrow(()-> 
			new IllegalArgumentException("Invalid credentials"));
		
	}

	@Override
	public User getUser(int id) {
		return ur.findById(id).orElseThrow(()-> 
		new IllegalArgumentException("Invalid user"));
	}

}
