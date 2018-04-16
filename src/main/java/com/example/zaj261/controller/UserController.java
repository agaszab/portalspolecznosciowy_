package com.example.zaj261.controller;

import com.example.zaj261.mod.User;
import com.example.zaj261.repository.UserRepository;
import com.example.zaj261.repository.UserRoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    public UserController(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }



    @GetMapping("/zapros")
    public String zapros (){
        return "zalogowani/lindex";

    }

    @GetMapping("/moiznajomi")
    public String moiznajomi (){
        return "zalogowani/login";

    }

    @GetMapping("/profil")
    public String profil (Model model, Principal principal){
        boolean doProfilu=true;
        String login=principal.getName();
        User user=userRepository.findByUsername(login);
        if(user!=null) {
            model.addAttribute("doProfilu", doProfilu);
            model.addAttribute("user", user);
            return "zalogowani/profil";
        } else return "/login";

    }

    @GetMapping("/szukaj")
    public String szukaj () {
            return "zalogowani/szukaj";

    }

    @PostMapping("/szukaj")
    public String pokazszukane (Model model, String username) {
        User user= userRepository.findByUsername(username);
        boolean doProfilu=false;
        if (user!=null) {
            model.addAttribute("user", user);
            model.addAttribute("doProfilu", doProfilu);
            return "zalogowani/profil";
        } else return "zalogowani/nouser";
    }


    @GetMapping("/edycja")
    public String edit (Model model, @RequestParam long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
            return "zalogowani/edycja";
        } else return "error";
    }

    @PostMapping("/edit")
    public String edit (User user,  @RequestParam long id){

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User newUser = userOptional.get();
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
            userRepository.save(newUser);
        }
        return "redirect:/profil";
    }
}
