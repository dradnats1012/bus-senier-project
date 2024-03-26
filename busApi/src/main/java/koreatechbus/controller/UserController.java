package koreatechbus.controller;

import koreatechbus.domain.User;
import koreatechbus.dto.user.LoginDTO;
import koreatechbus.dto.user.RegisterDTO;
import koreatechbus.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/registers")
    public User registerUser(@RequestBody RegisterDTO registerDTO) throws IllegalAccessException {
        return userService.registerUser(registerDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO);
    }

    /*@GetMapping("/information")
    public void getInformation(@RequestParam String token){
        System.out.println("들어옴");
        jwtProvider.getInformation(token);
    }*/

}
