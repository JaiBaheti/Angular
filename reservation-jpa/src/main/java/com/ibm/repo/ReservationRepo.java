package com.ibm.repo;

import java.util.List;

import com.ibm.entity.Passenger;
import com.ibm.entity.Ticket;

public interface ReservationRepo {
	int saveTicket(Ticket t);
	int addPassenger(Passenger p, int id);
	boolean removeTicket(int id);
	boolean removePassenger(int id);
	boolean updateTicket(Ticket t);
	boolean updatePassenger(Passenger p);
	Ticket fetchByPnr(int number);
	List<Ticket> fetchAllTickets();
}
