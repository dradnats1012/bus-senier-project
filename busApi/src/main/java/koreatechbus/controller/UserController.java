package koreatechbus.controller;

import koreatechbus.domain.User;
import koreatechbus.dto.user.RegisterDTO;
import koreatechbus.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
