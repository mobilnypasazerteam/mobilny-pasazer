package pl.sda.mobilnypasazerfront.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerService {

    private List<PassengerTicket> TICKETS;

    @Autowired
    private TicketRepository ticketRepository;
    
    public void registerTicket(PassengerTicketDTO dto) {
        PassengerTicket passengerTicket = dtoToEntity(dto);
        ticketRepository.save(passengerTicket);
        }

    private PassengerTicket dtoToEntity(PassengerTicketDTO dto) {

        return PassengerTicket.builder()
                .id( dto.getId())
                .phone( dto.getPhone() )
                .email( dto.getEmail() )
                .travel_date( dto.getTravel_date() )
                .start_point( dto.getStart_point() )
                .start_time( dto.getStart_time() )
                .intermediate_point( dto.getIntermediate_point() )
                .end_point( dto.getEnd_point() )
                .end_time( dto.getEnd_time() )
                .passenger_no( dto.getPassenger_no() )
                .reduced_mobility_type( dto.getReduced_mobility_type() )
                .additional_info( dto.getAdditional_info() )
                .build();

    }

    public List<PassengerTicket> getTicketList() {

        List<PassengerTicket> all = ticketRepository.findAll();

        List<PassengerTicketDTO> collect = all.stream().map( t -> t.toDto() ).collect( Collectors.toList() );


        return null;
    }
}