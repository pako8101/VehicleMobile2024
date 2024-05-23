package Vehiclemobile2024.web;

import Vehiclemobile2024.model.UserRegistrationDTO;
import Vehiclemobile2024.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register(){

        return "auth-register";
    }

    @PostMapping("/users/register")
    public String registerAuth(UserRegistrationDTO userRegistrationDTO){

        userService.registerUser(userRegistrationDTO);


        return "index";
    }

}
