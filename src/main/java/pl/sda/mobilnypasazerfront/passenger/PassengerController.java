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

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @Autowired
    private PassengerRegistrationService passengerRegistrationService;

    @GetMapping("/new-form")
    String registerTicket (Model model) {
        model.addAttribute( "ticket", new PassengerTicket() );
        return "passengerForm";
    }


    @PostMapping(value="/new-ticket")
    public String saveTicket(@ModelAttribute(name = "ticket") PassengerTicketDTO ticket, Model model){

        passengerService.registerTicket(ticket);
        model.addAttribute( "ticketList", passengerService.getTicketList());
        return "ticketList";
    }

    @GetMapping("/get-list")
    String lista (Model model) {
       model.addAttribute( "ticket", new PassengerTicket() );

        //get data mock
        ArrayList listaDowyswieltnia =  new ArrayList<PassengerTicket>(); //PassangerService.PassengerService();

        //sample data
        PassengerTicket P1 =new PassengerTicket();
        P1.setEmail("aaa@a.pl");
        listaDowyswieltnia.add(P1);
        PassengerTicket P2 =new PassengerTicket();
        P1.setEmail("bbbb@a.pl");
        listaDowyswieltnia.add(P2);

        model.addAttribute( "lista", listaDowyswieltnia );
        return "orderList2";
    }
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
        return "index";
    }
}
