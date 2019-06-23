package pl.sda.mobilnypasazerfront.passenger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PassengerController {

    @GetMapping("/new-form")
    String passengerForm () {
        return "passengerForm";
    }

    @GetMapping(value = "/users/index")
    public String showUserIndex(Model model) {
        return "userIndex";
    }
}
