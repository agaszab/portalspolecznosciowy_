package com.example.zaj261.controller;

import com.example.zaj261.mod.User;
import com.example.zaj261.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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



    @GetMapping("/panel/szukaj")
    public String wyszukiwanie() {
        return "panel/szukaj";
    }

    @PostMapping("/panel/szukaj")
    public String wyszukaj(Model model, @RequestParam String username) {
        User user = userRepository.findByUsername(username);
        int doProfilu=1;
        model.addAttribute("user", user);
        model.addAttribute("doProfilu", doProfilu);
        return "panel/user";
    }

    @GetMapping("/panel/user")
    public String szukaj(Model model, @RequestParam String username) {
        User user = userRepository.findByUsername(username);
        model.addAttribute("user", user);
        return "panel/user";
    }

    @GetMapping("/user")
    public String dane(Model model, @RequestParam long id) {
        User user = userRepository.findById(id);
        model.addAttribute("user", user);
        return "panel/user";
    }

    @GetMapping("/panel/users")
    public String users(Model model, @RequestParam boolean a) { // a -  zmienna pomocnicza by załadować userówa aktywnych lub nieaktywnych

        List<User> users= new ArrayList<>();

        if (a) {  // aktywni
            users = userRepository.findUsersByEnabledIsTrue();
        }
         else {  // nieaktywni
            users=userRepository.findUsersByEnabledIsFalse();
        }

        model.addAttribute("users", users);
        model.addAttribute("a", a);
        return "panel/users";
    }


    @PostMapping("/panel/edit")
    public String edituser (User user,  @RequestParam long id){

        User newUser = userRepository.findById(id);

        if (newUser!=null) {
            if (!user.getFirstName().equals("")) {
                newUser.setFirstName(user.getFirstName());
            }
            if (!user.getLastName().equals("")) {
                newUser.setLastName(user.getLastName());
            }
            if (!user.getEmail().equals("")) {
                newUser.setEmail(user.getEmail());
            }
            newUser.setImg(user.getImg());
            newUser.setEnabled(user.isEnabled());
            userRepository.save(newUser);
        }
        return "redirect:/panel/users?a=true";
    }

    @GetMapping("/aktywacja")
            public String aktywacja ( @RequestParam long id){   // aktywacja tych z listy co zaznaczeni

        User user = userRepository.findById(id);
        user.setEnabled(true);
        userRepository.save(user);
        return "redirect:/panel/users?a=true";
    }

    @GetMapping("/panel/eduser")
    public String edytujosoba(@RequestParam Long id, Model model) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
            return "panel/eduser";
        }
        return "redirect:panel/users";
    }


    @GetMapping("panel/deluser")
    public String kasujosobe(Model model, @RequestParam long id) {
        User user = userRepository.findById(id);
        if (user!=null && !user.getUsername().equals("admin"))
        userRepository.delete(user);
        boolean a=true;
        model.addAttribute("a", a);
        return "redirect:users?a=true";
    }
}

