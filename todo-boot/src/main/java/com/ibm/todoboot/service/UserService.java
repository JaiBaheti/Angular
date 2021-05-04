package com.ibm.todoboot.service;

import com.ibm.todoboot.POJO.Login;
import com.ibm.todoboot.entity.User;

public interface UserService {
	int addUser(User user);
	int addTaskToUser(int userId, int id);
	User authenticate(Login login);
	User getUser(int id);
}
