package com.ibm.todoboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.todoboot.entity.ToDo;
import com.ibm.todoboot.service.ToDoService;

@CrossOrigin
@RestController
@RequestMapping(value="/task")
public class ToDoController {
	@Autowired
	private ToDoService ts;
	
	@GetMapping(value="/getTask/{id}")
	public ToDo getTask(@PathVariable int id) {
		return ts.getTask(id);		
	}
	
	@PostMapping(value="/addTask/{userid}")
	public String addTask(@RequestBody ToDo task,@PathVariable int userid) {
		 ts.addTask(task,userid);
		 return "Task added";		
	}
	
	@PostMapping(value="/removeTask/{id}")
	public int removeTask(@PathVariable int id) {
		return ts.removeTask(ts.getTask(id).getId());
	}
	
	@PutMapping(value="/updateTask")
	public ToDo updateTask( @RequestBody ToDo task) {
		return ts.updateTask(task);
	}
	@PostMapping(value="/getTaskByUser/{id}")
	public List<ToDo> getTaskByUser(@PathVariable int id){
		return ts.todoByUser(id);
	}

}
