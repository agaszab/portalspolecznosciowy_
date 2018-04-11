package com.example.zaj261;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    public String main (){
    return "index";

    }
    @GetMapping("/login")
    public String login (){
        return "login";

    }

    @PostMapping("/logowanie")
    public String logowanie (){
        return "lindex";

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
