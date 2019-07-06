package pl.sda.mobilnypasazerfront.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    private final PassengerTicketRepository passengerTicketRepository;

    @Autowired
    public PassengerService(PassengerTicketRepository passengerTicketRepository) {
        this.passengerTicketRepository = passengerTicketRepository;
    }

    public void registerTicket(PassengerTicketDTO dto) {
        PassengerTicket passengerTicket = dtoToEntity(dto);
        passengerTicketRepository.save(passengerTicket);
        }

    private PassengerTicket dtoToEntity(PassengerTicketDTO dto) {

        return PassengerTicket.builder()
                .id( dto.getId())
                .phone( dto.getPhone() )
                .email( dto.getEmail() )
                .travelDate( dto.getTravelDate() )
                .startPoint( dto.getStartPoint() )
                .startTime( dto.getStartTime() )
                .intermediatePoint( dto.getIntermediatePoint() )
                .endPoint( dto.getEndPoint() )
                .endTime( dto.getEndTime() )
                .passengerNo( dto.getPassengerNo() )
                .reducedMobilityType( dto.getReducedMobilityType() )
                .additionalInfo( dto.getAdditionalInfo() )
                .build();

    }

    public List<PassengerTicketDTO> getTicketList() {

        List<PassengerTicket> all = passengerTicketRepository.findAll();

        return entityToDTO( all );
    }

    private List<PassengerTicketDTO> entityToDTO (List<PassengerTicket> passengerTickets) {
        List<PassengerTicketDTO> passengerTicketDTO = new ArrayList<>(  );
        for (PassengerTicket ticket : passengerTickets) {
            passengerTicketDTO.add(PassengerTicketDTO.builder()
                    .phone( ticket.getPhone() )
                    .email( ticket.getEmail() )
                    .travelDate( ticket.getTravelDate() )
                    .startPoint( ticket.getStartPoint() )
                    .startTime( ticket.getStartTime() )
                    .intermediatePoint( ticket.getIntermediatePoint() )
                    .endPoint( ticket.getEndPoint() )
                    .endTime( ticket.getEndTime() )
                    .passengerNo( ticket.getPassengerNo() )
                    .reducedMobilityType( ticket.getReducedMobilityType() )
                    .additionalInfo( ticket.getAdditionalInfo() )
                    .build());
        }
        return passengerTicketDTO;
    }

}