package com.ibm.todoboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.todoboot.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findByNameAndPassword(String name, String password);
}
