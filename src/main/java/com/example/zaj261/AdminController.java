package com.example.zaj261;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/admin")
    public String adm() {
        return "panel/admin";
    }

    @GetMapping("panel/szukaj")
    public String wyszukiwanie() {
        return "panel/szukaj";
    }

    @PostMapping("panel/szukaj")
    public String wyszukaj(Model model, @RequestParam String username) {
        User user = userRepository.findByUsername(username);
        model.addAttribute("user", user);
        return "panel/user";
    }

    @GetMapping("panel/user")
    public String szukaj(Model model, @RequestParam String username) {
        User user = userRepository.findByUsername(username);
        model.addAttribute("user", user);
        return "panel/user";
    }
    @GetMapping("/panel/users")
    public String users(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "panel/users";
    }



    @PostMapping("/edituser")
    public String zmiendane(Model model, @RequestParam long id) {
     return "panel/users";
    }


}

