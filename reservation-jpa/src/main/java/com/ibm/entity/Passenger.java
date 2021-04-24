package com.ibm.entity;



import java.util.List;

import javax.persistence.*;



@Entity
public class Passenger {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	private String gender;	
	@ManyToOne
	@JoinColumn(name="pnr")	
	private Ticket tickets;
	
	
	public Ticket getTickets() {
		return tickets;
	}
	public void setTickets(Ticket tickets) {
		this.tickets = tickets;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
