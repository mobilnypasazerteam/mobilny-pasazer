package pl.sda.mobilnypasazerfront.passenger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerTicketRepository extends JpaRepository<PassengerTicket, Long> {
}
