package koreatechBus.controller;

import koreatechBus.auth.JWTProvider;
import koreatechBus.domain.User;
import koreatechBus.dto.user.LoginDTO;
import koreatechBus.dto.user.RegisterDTO;
import koreatechBus.service.UserService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
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
