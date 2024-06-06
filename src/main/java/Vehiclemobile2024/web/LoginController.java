package Vehiclemobile2024.web;

import Vehiclemobile2024.model.UserLoginDTO;
import Vehiclemobile2024.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {

        return "auth-login";
    }

    @PostMapping("/login")

    public String login(UserLoginDTO userLoginDTO) {

        userService.login(userLoginDTO);


        return "redirect:/";
    }

}
