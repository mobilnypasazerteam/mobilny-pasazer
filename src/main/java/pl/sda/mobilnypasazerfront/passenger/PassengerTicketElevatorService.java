package pl.sda.mobilnypasazerfront.passenger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PassengerTicketElevatorService {
    private static final Logger log = LoggerFactory.getLogger(PassengerTicketElevatorService.class);

//    @Value("rest.api.elevtor.url")
//    private String restApiUrl;

    private RestTemplate restTemplate = new RestTemplate();


    public List<PassengerElevator> ticketList() {
        PassengerElevator[] elev = restTemplate.getForObject("https://mobilny-pasazer.herokuapp.com/api/elevators-malfunction-list", PassengerElevator[].class);
        List<PassengerElevator> passengerElevators = Arrays.asList(elev);

        for (PassengerElevator passengerElevator : passengerElevators) {
            log.info("Elevator : " + passengerElevator.toString());
        }

        return passengerElevators;
    }

}
