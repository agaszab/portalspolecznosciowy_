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

    @GetMapping("/zaproszenia")
    public String zaprosenia (Model model, Principal principal){
        User user=zalogowany(principal);
        List <Friends> friends;
        friends=friendsRepository.findByFriendIdAndFriendFalse(user.getId());
        if (friends.size()>0) {
            model.addAttribute("friends", friends);
            return "zalogowani/zaproszenia?t=1";
        } else  return "zalogowani/zaproszenia?t=0";


    }

    @PostMapping ("/akceptuj")
    public String akceptuj(List<User> users, Principal principal){




        return "zalogowani/znajomi";
    }

    @GetMapping("/moiznajomi")
    public String moiznajomi (){
        return "zalogowani/login";

    }

   /* @GetMapping("/profil")
    public String profil (Model model, Principal principal, @RequestParam int doProfilu){

        String login=principal.getName();
        User user=userRepository.findByUsername(login);
        if(user!=null) {
            model.addAttribute("doProfilu", doProfilu);
            model.addAttribute("user", user);
            return "zalogowani/profil";
        } else return "/login";

    } */

    @GetMapping("/profil")
    public String profil (Model model, Principal principal, @RequestParam int doProfilu){

        User user=zalogowany(principal);
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
        User user= userRepository.findByUsername(username);
        int doProfilu=2;
        if (user!=null) {
            model.addAttribute("user", user);
            model.addAttribute("doProfilu", doProfilu);
            return "zalogowani/profil";
        } else return "zalogowani/nouser";
    }

    @GetMapping("/zaproszenie")
    public String zapros (Principal principal, @RequestParam long zid) {
         User loginUser=zalogowany(principal);
         User ufriend=userRepository.findById(zid);
         Friends friends=new Friends();
         friends.setUid(loginUser.getId());
         friends.setFriendId(zid);
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
