package com.example.zaj261.controller;


import com.example.zaj261.mod.User;
import com.example.zaj261.repository.FriendsRepository;
import com.example.zaj261.repository.UserRepository;
import com.example.zaj261.repository.UserRoleRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
    public String main() {
        return "wszyscy/index";
    }


    @GetMapping("/login")
    public String login() {
        return "wszyscy/login";

    }

    @PostMapping("/login")
    public String logowanie(Model model, Principal principal) {
        String login = principal.getName();
        User user = userRepository.findByUsername(login);
        if (user != null) {
            model.addAttribute("user", user);
            return "lindex";
        } else return "wszyscy/index";

    }

    @GetMapping("/wyloguj")
    public String wyloguj() {

        return "/zalogowani/logout_form";
    }


    @PostMapping("/logout")
    public String logoutme() {

        return "/";
    }


    @GetMapping("/rejestracja")
    public String rejestracja(Model model) {
        model.addAttribute("user", new User());
        return "wszyscy/rejestracja";

    }

    @PostMapping("/register")
    public String register(User user) {
        if (!user.getUsername().equals("") && !user.getPassword().equals("")&& !user.getEmail().equals("")) {
            user.setEnabled(false);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encode = encoder.encode(user.getPassword());
            user.setPassword(encode);
            userRepository.save(user);
            return "wszyscy/zarejestrowany";
        }
        return "brakdanych";
    }

    @GetMapping("/kontakt")
    public String kontakt(Model model, Principal principal) {
        boolean zalogowany = false;
        if (principal != null) zalogowany = true;
        model.addAttribute("zalogowany", zalogowany);
        return "/wszyscy/kontakt";
    }

    @PostMapping("/adminkontakt")
    public String adminkontakt() {

        return "wszyscy/wyslana";


    }


    @GetMapping("/koduj")
    @ResponseBody
    public String koduj(@RequestParam String text) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(text);
        return encode;
    }
}
