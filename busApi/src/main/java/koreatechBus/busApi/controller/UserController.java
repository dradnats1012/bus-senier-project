package koreatechBus.busApi.controller;

import koreatechBus.busApi.domain.User;
import koreatechBus.busApi.dto.user.RegisterDTO;
import koreatechBus.busApi.service.UserService;
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
