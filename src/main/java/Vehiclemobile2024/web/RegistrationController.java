package Vehiclemobile2024.web;

import Vehiclemobile2024.model.UserRegistrationDTO;
import Vehiclemobile2024.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @ModelAttribute("registerDTO")
    public UserRegistrationDTO registerDTO(){
      return   new UserRegistrationDTO();
    }

    @GetMapping("/register")
    public String register(){

        return "auth-register";
    }

    @PostMapping("/register")
    public String registerAuth(UserRegistrationDTO registerDTO){

        userService.registerUser(registerDTO);


        return "redirect:/";
    }

}
