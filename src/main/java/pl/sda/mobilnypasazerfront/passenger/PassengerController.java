package pl.sda.mobilnypasazerfront.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class PassengerController {

    @Autowired
    private PassengerRegistrationService passengerRegistrationService;

    @Autowired
    private PassengerService passengerService;




    @GetMapping(value = "/users/index")
    public String showUserIndex() {
        return "userIndex";
    }

    @GetMapping(value = "/register")
    public String showForm(Model model){
        PassengerRegistrationDTO passengerRegistrationDTO = new PassengerRegistrationDTO();
        model.addAttribute("passengerDto", passengerRegistrationDTO);
        model.addAttribute("sex", Sex.values());
        return "registerForm";
    }

    @PostMapping(value="/register")
    public String register(@ModelAttribute(name = "passengerDto") @Valid PassengerRegistrationDTO passengerDto,
                           BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("sex", Sex.values());
            return "registerForm";
        }
        passengerRegistrationService.registerUser(passengerDto);
        return "home2";
    }

    @GetMapping(value = "/new-form")
    public String showTicketForm(Model model){
        PassengerTicketDTO passengerTicketDTO = new PassengerTicketDTO();
        model.addAttribute("passengerTicketDTO", passengerTicketDTO);
     //   model.addAttribute("sex", Sex.values());
        return "passengerForm";
    }

    @PostMapping(value="/new-ticket")
    public String saveTicket (@ModelAttribute(name = "passengerTicketDTO") @Valid PassengerTicketDTO passengerTicketDTO,
                           BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("passengerTicketDTO", passengerTicketDTO);
            return "passengerForm";
        }
        passengerService.registerTicket(passengerTicketDTO);
        return "ticketList";
    }

    @GetMapping("/tickets")
    public String lista (Model model) {
        model.addAttribute( "ticketList", passengerService.getTicketList() );
        return "ticketList";
    }

}
