package com.ibm.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.ibm.entity.Passenger;
import com.ibm.entity.Ticket;

@Repository
public class ReservationRepoImpl implements ReservationRepo {
	@PersistenceContext
	private EntityManager em;
	@Transactional(value = TxType.REQUIRED)
	public int saveTicket(Ticket t) {		
		em.persist(t);
		return t.getPnr();
	}
	@Transactional(value = TxType.REQUIRED)
	public int addPassenger(Passenger p, int id) {
		Ticket t = em.find(Ticket.class, id);
		p.setTickets(t);
		em.persist(p);
		return p.getId();
	}
	@Transactional
	public boolean removeTicket(int id) {
		Ticket t = em.find(Ticket.class, id);
		em.remove(t);
		return true;
	}
	@Transactional
	public boolean removePassenger(int id) {
		
		Passenger p = em.find(Passenger.class, id);
		em.remove(p);
		return true;
	}
	@Transactional
	public boolean updateTicket(Ticket t) {
		em.merge(t);
		return true;
	}
	@Transactional
	public boolean updatePassenger(Passenger p) {
		em.merge(p);
		return true;
	}

	public Ticket fetchByPnr(int number) {
		return em.find(Ticket.class, number);
		//return tick;
	}

	public List<Ticket> fetchAllTickets() {
		return em.createNamedQuery("allFetch").getResultList();
	}
	
		
}
