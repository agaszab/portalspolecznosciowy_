package com.example.zaj261;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.UserRepository;

import java.security.Principal;

@Controller
public class HomeController {

    UserRepository userRepository;


    @GetMapping("/")
    public String main (){
    return "index";

    }
    @GetMapping("/login")
    public String login (){
        return "login";

    }

    @PostMapping("/logowanie")
    public String logowanie (Model model, Principal principal){
            String login=principal.getName();
            User user=userRepository.findByUsername(login);
            if(user!=null) {
                model.addAttribute("user", user);
                return "lindex";
            } else return "login";



    }

    @GetMapping("/rejestracja")
    public String rejestracja (){
        return "rejestracja";

    }

    @PostMapping("/register")
    public String register (){

        // tu będzie zapis do bazy

        return "zarejestrowany";

    }

    @GetMapping("/profil")
    public String profil (Model model, Principal principal){

        String login=principal.getName();
        User user=userRepository.findByUsername(login);
        if(user!=null) {
            model.addAttribute("user", user);
            return "profil";
        } else return "login";

    }


    @GetMapping("/admin")
    public String adm (){
        return "admin";

    }

    @GetMapping ("/koduj")
    @ResponseBody
    public String koduj (@RequestParam String text){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(text);
        return encode;
    }
}
