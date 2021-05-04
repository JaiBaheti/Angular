package com.ibm.todoboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.todoboot.POJO.Login;
import com.ibm.todoboot.entity.User;
import com.ibm.todoboot.repository.ToDoRepo;
import com.ibm.todoboot.service.ToDoService;
import com.ibm.todoboot.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService us;
	@Autowired
	private ToDoRepo tr;
	@Autowired
	private ToDoService ts;
	
	@PostMapping(value="/addUser")
	public String addUser(@RequestBody User user) {
		us.addUser(user);
		return "User added";
	}
	@GetMapping(value="/getUser/{id}")
	public User getUser(@PathVariable int id){
		return us.getUser(id);
	}
	@GetMapping(value="/auth", consumes="application/json", produces="application/json")
	public  ResponseEntity<?> authentication(@RequestBody Login login, HttpSession session) {
		User u = us.authenticate(login);
		if(u != null) {	
			//session.setAttribute("USER", u); 
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Invalid username or password.",HttpStatus.NOT_FOUND);
		}		
	}
}
