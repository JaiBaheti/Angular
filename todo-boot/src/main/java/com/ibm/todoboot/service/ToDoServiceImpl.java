package com.ibm.todoboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.todoboot.entity.ToDo;
import com.ibm.todoboot.repository.ToDoRepo;
import com.ibm.todoboot.repository.UserRepo;


@Service
public class ToDoServiceImpl implements ToDoService {
	@Autowired
	private ToDoRepo tr;
	@Autowired
	private UserRepo ur;
	@Override
	public int addTask(ToDo task,int userid) {
		task.setUsers(ur.findById(userid).get());
		tr.save(task);
		return task.getUsers().getUserId();
	}
	@Override
	public int removeTask(int id) {
		ToDo task =tr.findById(id).get();
		tr.delete(task);
		return task.getId();
	}
	@Override
	public ToDo updateTask(ToDo task) {
		tr.save(task);
		return task;
	}
	@Override
	public List<ToDo> todoByUser(int userid) {
		return tr.findAllByUsers(userid);		
	}
	@Override
	public ToDo getTask(int id) {
		return tr.findById(id).orElseThrow(()-> 
		new IllegalArgumentException("Invalid credentials"));
	}

}
