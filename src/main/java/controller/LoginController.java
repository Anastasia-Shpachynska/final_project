package controller;

import form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/open/auth")
public class LoginController {


    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("LoginForm", new LoginForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("LoginForm") LoginForm loginForm) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        return "redirect:/login"; // або інша сторінка після реєстрації
    }
}
