import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.Passenger;
import com.ibm.entity.Ticket;
import com.ibm.repo.ReservationRepo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestReservation {
	@Autowired
	private ReservationRepo rr;	
	
	@Test
	public void testSaveTicket() {
		Ticket t = new Ticket();
		t.setPnr(123);
		t.setDate(LocalDate.now());
		t.setAmount(1200);
		assertNotNull(rr.saveTicket(t));		
	}
	@Test
	public void testAddPassenger() {
		Passenger p =new Passenger();
		p.setAge(15);
		p.setGender("M");
		p.setName("Sam");
		assertNotNull(rr.addPassenger(p, 12));
	}
	@Test
	public void testRemoveTicket() {
		assertTrue(rr.removeTicket(23));
	}
	@Test
	public void testRemovePassenger() {
		assertTrue(rr.removePassenger(24));
	}
	@Test
	public void testUpdateTicket() {
		Ticket t = new Ticket();
		t.setPnr(25);
		t.setAmount(1250);
		t.setDate(LocalDate.now());
		assertTrue(rr.updateTicket(t));
	}
	@Test
	public void testUpdatePassenger() {
		Passenger p =new Passenger();
		p.setAge(15);
		p.setId(28);
		p.setGender("F");
		p.setName("Hanna");		
	}
	@Test
	public void testFetchAll() {
		Ticket t = new Ticket();
	}
}
