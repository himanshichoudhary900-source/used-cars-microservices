package com.usedcars.webapp.controller;

import com.usedcars.webapp.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequestMapping("/user")
public class UserPageController {

    @Autowired
    private WebClient userWebClient;


    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("title", "Login");
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,     // ✅ Matches template
                       @RequestParam String password,
                       Model model) {
        System.out.println("Login attempt: " + email);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute("user", new UserDto());
        return "user/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserDto userDto, Model model) {
        System.out.println("Registering user: " + userDto);
        
        return "redirect:/user/login";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        UserDto user = getMockUser();
        
        model.addAttribute("title", "My Profile");
        model.addAttribute("user", user);
        return "user/profile";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }


    private UserDto getMockUser() {
        return new UserDto(1L, "johndoe", "john@example.com", 
                          "John", "Doe", "1234567890", 
                          "123 Main St", "CUSTOMER");
    }
    

    /*
    private UserDto authenticateUser(String username, String password) {
        return userWebClient.post()
                .uri("/api/auth/login")
                .bodyValue(Map.of("username", username, "password", password))
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();
    }
    
    private void registerUser(UserDto userDto) {
        userWebClient.post()
                .uri("/api/auth/register")
                .bodyValue(userDto)
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();
    }
    */
    
}