package com.example.zaj261;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String main (){
    return "witaj";

    }
    @GetMapping("/login")
    @ResponseBody
    public String login (){
        return "login";

    }

}
