package adzarei.loe.server.security.authentication.controllers;

import adzarei.loe.server.security.authentication.services.UserAuthenticationService;
import adzarei.loe.server.security.model.LoginUser;
import adzarei.loe.server.security.services.LoginUserService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(AuthUserController.BASE_URL)
public class AuthUserController {

    public static final String BASE_URL = "/auth/users";


//TODO: make sure the services aren't null;
    @NonNull
    public final UserAuthenticationService authService;

    public AuthUserController(UserAuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestParam String username, @RequestParam String password){


        LoginUser user = LoginUser.builder()
                .username(username)
                .password(password)
                .build();

        authService.register(user).orElseThrow(() -> new RuntimeException("Error: No user registered"));
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){

        String uuid = authService.login(username,password).orElseThrow(() -> new RuntimeException("Invalid login"));

        return uuid;

    }


}
