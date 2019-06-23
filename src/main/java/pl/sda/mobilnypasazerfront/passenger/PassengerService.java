package pl.sda.mobilnypasazerfront.passenger;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    private List<PassengerTicket> TICKETS;

//    static {
//        //TICKETS.add(  )
//
//    }

    public PassengerService() {
        this.TICKETS = new ArrayList<>();
    }

    public void save(PassengerTicket ticket) {
        TICKETS.add( ticket );
      }

    List<PassengerTicket> getTicketList () {
        return TICKETS;
      }




}
