package com.ibm.todoboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.todoboot.entity.ToDo;

public interface ToDoRepo extends JpaRepository<ToDo, Integer> {
	@Query("From ToDo where id= id")
	List<ToDo> findAllByUsers(@Param(value = "id") int id);
}
