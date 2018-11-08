package adzarei.loe.server.security.authentication.controllers;

import adzarei.loe.server.security.authentication.model.Token;
import adzarei.loe.server.security.authentication.services.UserAuthenticationService;
import adzarei.loe.server.security.model.LoginUser;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
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


        LoginUser user = new LoginUser();
        user.setUsername(username);
        user.setPassword(password);

        authService.register(user).orElseThrow(() -> new RuntimeException("Error: No user registered"));
    }

    @PostMapping("/login")
    public Token login(@RequestParam String username, @RequestParam String password){

        String uuid = authService.login(username,password).orElseThrow(() -> new RuntimeException("Invalid login"));

        return new Token(uuid);

    }


}
