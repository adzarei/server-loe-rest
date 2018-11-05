package adzarei.loe.server.security.controllers;

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

    @NonNull
    LoginUserService userService;


    public AuthUserController(UserAuthenticationService authService, LoginUserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginUser register(@RequestParam String username, @RequestParam String password){


        LoginUser user = LoginUser.builder()
                .username(username)
                .password(password)
                .build();

        return userService.saveLoginUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){

        return authService.login(username,password).orElseThrow(() -> new RuntimeException("Invalid login"));

    }


}
