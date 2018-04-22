package com.example.zaj261.controller;


import com.example.zaj261.mod.Friends;
import com.example.zaj261.mod.User;
import com.example.zaj261.repository.FriendsRepository;
import com.example.zaj261.repository.UserRepository;
import com.example.zaj261.repository.UserRoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private FriendsRepository friendsRepository;

    public UserController(UserRepository userRepository, UserRoleRepository userRoleRepository, FriendsRepository friendsRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.friendsRepository = friendsRepository;

    }



    @GetMapping("/users")
    public String listusers(Model model) {

        List<User> users= new ArrayList<>();
        users = userRepository.findUsersByEnabledIsTrue();
        model.addAttribute("users", users);
        return "zalogowani/users";
    }

    @GetMapping("/lindex")
    public String glowna() {

        return "zalogowani/lindex";
    }

    @GetMapping ("/akceptuj")
    public String akceptuj(@RequestParam long id){

        Friends fr=friendsRepository.findById(id);
        fr.setFriend(true);
        friendsRepository.save(fr);
     return "redirect:/zaproszenia";
    }

    @GetMapping ("/odrzuc")
    public String odrzuc(@RequestParam long id){
        Friends fr=friendsRepository.findById(id);
        friendsRepository.delete(fr);
        return "redirect:/zaproszenia";
    }

    @GetMapping("/moiznajomi")
    public String moiznajomi (Model model, Principal principal){

        User zalogowany=zalogowany(principal);
        List <Friends> friends;
        int t=0;
        friends=friendsRepository.findByUidAndFriendTrue(zalogowany.getId());

        if (friends.size()>0) {
            t=1;
            model.addAttribute("t", t);
            model.addAttribute("friends", friends);
            return "zalogowani/znajomi";
        } else {
            model.addAttribute("t", t);
            return "zalogowani/znajomi";
        }
    }


    @GetMapping("/delfriend")
    public String delfriend (@RequestParam long id){
        Friends fr=friendsRepository.findById(id);
        friendsRepository.delete(fr);
        return "redirect:/moiznajomi";
    }


    @GetMapping("/profil")
    public String profil (Model model, Principal principal, @RequestParam int doProfilu){
        User user=zalogowany(principal);
        if(user!=null) {
            model.addAttribute("doProfilu", doProfilu);
            model.addAttribute("user", user);
            return "zalogowani/profil";
        } else return "/login";

    }


    @GetMapping("/profiluser")
    public String profilusera (Model model, @RequestParam long id, @RequestParam int doProfilu){
        User user=userRepository.findById(id);
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
    public String pokazszukane (Model model, @RequestParam  String username) {
        User user= userRepository.findByUsernameAndEnabledTrue(username);
        int doProfilu=2;
        if (user!=null) {
            model.addAttribute("user", user);
            model.addAttribute("doProfilu", doProfilu);
            return "zalogowani/profil";
        } else return "zalogowani/nouser";
    }


    @GetMapping("/zaproszenia")
    public String zaprosenia (Model model, Principal principal){
        User zalogowany=zalogowany(principal);
        List <Friends> friends;
        int t=0;
        friends=friendsRepository.findByFidAndFriendFalse(zalogowany.getId());
        if (friends.size()>0) {
            t=1;
            model.addAttribute("t", t);
            model.addAttribute("friends", friends);
            return "zalogowani/zaproszenia";
        } else {
            model.addAttribute("t", t);
            return "zalogowani/zaproszenia";
        }

    }


    @PostMapping("/zaproszenie")
    public String zapros (Principal principal, @RequestParam long zid) {
         User loginUser=zalogowany(principal);
         User ufriend=userRepository.findById(zid);
         Friends friends=new Friends();
         friends.setUid(loginUser.getId());
         friends.setfid(zid);
         friends.setFriendname(ufriend.getUsername());
         friends.setFriend(false);
         friendsRepository.save(friends);
         return "zalogowani/zaproszenie";
    }

    @GetMapping("/edycja")
    public String edit (Model model, @RequestParam long id) {
           User user=userRepository.findById(id);
           if (user!=null) {
           model.addAttribute("user", user);
           return "zalogowani/edycja";
        } else return "error";
    }

    @PostMapping("/edit")
    public String edit (User user,  @RequestParam long id){

        User newUser=userRepository.findById(id);
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
            userRepository.save(newUser);
        }
        return "redirect:/profil?doProfilu=3";
    }

    public User zalogowany (Principal principal)
    {
        String login=principal.getName();
        User user=userRepository.findByUsername(login);
        if(user!=null) {
            return user;
        } else return null;
    }


}
