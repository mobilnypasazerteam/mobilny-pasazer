package pl.sda.mobilnypasazerfront.passenger;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    private static List<PassengerTicket> TICKETS;

    static {
        //TICKETS.add(  )

    }

    public PassengerService() {
        this.TICKETS = new ArrayList<>();
    }

    public void save(PassengerTicket ticket) {
      }
}
