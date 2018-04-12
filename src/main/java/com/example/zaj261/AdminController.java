package com.example.zaj261;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/admin")
    public String adm (){
        return "panel/admin";
    }

    @GetMapping("/panel/users")
    public String users (Model model){
            List<User> users = userRepository.findAll();
            model.addAttribute("users", users);
    return "panel/users";
    }
}
