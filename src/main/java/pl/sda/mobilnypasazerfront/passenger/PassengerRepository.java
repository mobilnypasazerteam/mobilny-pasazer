package pl.sda.mobilnypasazerfront.passenger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long>
{
        boolean existsByUsername(String username);
        boolean existsByPasswordHash(String username);
}