package com.ibm.todoboot.service;

import java.util.List;

import com.ibm.todoboot.entity.ToDo;

public interface ToDoService {
	int addTask(ToDo task,int userid);
	int removeTask(int id);
	ToDo updateTask(ToDo task);
	ToDo getTask(int id);
	List<ToDo> todoByUser(int userid);
}
