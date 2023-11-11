package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/registration")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user) {
        String result = "";
        System.out.println(user);
        if(user.getPassword().equals(user.getPasswordAgain())) {
            try{
                service.registerUser(user);
                result = "home";
            }catch (Exception ex) {
                ex.printStackTrace();
                result =  "error";
            }
        }
        return result;
    }
    @GetMapping("/authorisation")
    public String authorisation (Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "authorisation";
    }
}
