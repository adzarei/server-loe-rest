package adzarei.loe.server.security.authentication.services;

import adzarei.loe.server.security.model.ActiveToken;
import adzarei.loe.server.security.model.LoginUser;

import java.util.Optional;

public interface UserAuthenticationService {

    Optional<String> login(String username, String password);

    Optional<LoginUser> findLoginUserByTokenUuid(String token);

    void logout(LoginUser user);

    Optional<LoginUser> register(LoginUser user);
}
