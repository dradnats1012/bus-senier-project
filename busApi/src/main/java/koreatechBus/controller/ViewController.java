package koreatechBus.controller;

import koreatechBus.dto.etc.MainDTO;
import koreatechBus.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
    private final UserService userService;
    public ViewController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/main")
    public MainDTO getMain(@RequestParam String token){
        return userService.getMainPage(token);
    }
}
