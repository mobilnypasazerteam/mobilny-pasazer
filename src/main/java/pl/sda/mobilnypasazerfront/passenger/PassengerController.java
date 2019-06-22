package pl.sda.mobilnypasazerfront.passenger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PassengerController {

    @RequestMapping("/new-form")
    String passengerForm () {
        return "passengerForm";
    }
}
