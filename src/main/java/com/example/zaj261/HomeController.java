package com.example.zaj261;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
public class HomeController {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    public HomeController(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

  @GetMapping("/")
    public String main (){



    return "wszyscy/index";

    }


    @GetMapping("/lindex")
    public String zalogowani (){
        return "zalogowani/lindex";

    }

    @GetMapping("/login")
    public String login (){
        return "wszyscy/login";

    }

    @PostMapping("/login")
    public String logowanie (Model model, Principal principal){
            String login=principal.getName();
            User user=userRepository.findByUsername(login);
            if(user!=null) {
                model.addAttribute("user", user);
                return "zalogowani/lindex";
            } else return "wszyscy/login";

    }

    @GetMapping("/wyloguj")
    public String wyloguj () {
        return "/zalogowani/logout_form";
    }

    @PostMapping ("/logout")
        public String logoutme ()  {
                return "/";
    }
    @GetMapping("/rejestracja")
    public String rejestracja (Model model){
        model.addAttribute("user", new User());
        return "wszyscy/rejestracja";

    }

    @PostMapping("/register")
    public String register (){

            return "wszyscy/zarejestrowany";


    }
    @GetMapping("/kontakt")
    public String kontakt (Model model, Principal principal) {
        boolean zalogowany=false;
        if (principal!=null) zalogowany=true;
        model.addAttribute("zalogowany", zalogowany);
        return "/wszyscy/kontakt";
    }

    @PostMapping("/adminkontakt")
    public String  adminkontakt(){

        return "wszyscy/wyslana";


    }

    @GetMapping("/profil")
    public String profil (Model model, Principal principal){

        String login=principal.getName();
        User user=userRepository.findByUsername(login);
        if(user!=null) {
            model.addAttribute("user", user);
            return "zalogowani/profil";
        } else return "wszyscy/login";

    }




    @GetMapping ("/koduj")
    @ResponseBody
    public String koduj (@RequestParam String text){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(text);
        return encode;
    }
}
