package pl.sda.mobilnypasazerfront.passenger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<PassengerTicket, Long> {
}
