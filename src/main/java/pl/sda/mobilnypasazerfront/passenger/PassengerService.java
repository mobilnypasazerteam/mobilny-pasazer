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

    public List<PassengerTicketDTO> getTicketList() {

        List<PassengerTicket> all = ticketRepository.findAll();

        return entityToDTO( all );
    }

    private List<PassengerTicketDTO> entityToDTO (List<PassengerTicket> passengerTickets) {
        List<PassengerTicketDTO> passengerTicketDTO = new ArrayList<>(  );
        for (PassengerTicket ticket : passengerTickets) {
            passengerTicketDTO.add(PassengerTicketDTO.builder()
                    .phone( ticket.getPhone() )
                    .email( ticket.getEmail() )
                    .travel_date( ticket.getTravel_date() )
                    .start_point( ticket.getStart_point() )
                    .start_time( ticket.getStart_time() )
                    .intermediate_point( ticket.getIntermediate_point() )
                    .end_point( ticket.getEnd_point() )
                    .end_time( ticket.getEnd_time() )
                    .passenger_no( ticket.getPassenger_no() )
                    .reduced_mobility_type( ticket.getReduced_mobility_type() )
                    .additional_info( ticket.getAdditional_info() )
                    .build());
        }
        return passengerTicketDTO;
    }

}