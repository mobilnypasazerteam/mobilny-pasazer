package pl.sda.mobilnypasazerfront;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.time.LocalDateTime;

@Controller
class HomeController {

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        return "home2";
    }
    @RequestMapping("/login")
    public String showLoginPage(@RequestParam(required = false) String register,
                                Model model) {
        model.addAttribute("register", register);
        return "loginForm";
    }
}