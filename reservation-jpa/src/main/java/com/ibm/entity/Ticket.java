package com.ibm.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
@Entity
@NamedQuery(name = "allFetch", query = "select t from Ticket t")
@Table(name="Ticket")
public class Ticket {
	@Id
	@GeneratedValue
	private int pnr;
	@Column(name="date_of_journey")
	private LocalDate date;
	@Column(name="price",length=10)
	private double amount;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tickets")
	private List<Passenger> passengers = new ArrayList<Passenger>();
	
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
