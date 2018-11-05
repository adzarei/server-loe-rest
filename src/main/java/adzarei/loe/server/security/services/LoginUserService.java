package adzarei.loe.server.security.services;


import adzarei.loe.server.security.model.ActiveToken;
import adzarei.loe.server.security.model.LoginUser;

import java.util.Optional;

public interface LoginUserService {

     Optional<LoginUser> saveLoginUser(LoginUser loginUser);
     Optional<LoginUser> findLoginUser(Long id);
     Optional<LoginUser> findLoginUserByUsername(String username);
     Optional<LoginUser> patchLoginUser(Long id, LoginUser user);

    Optional<LoginUser> findLoginUserByToken(ActiveToken token);
}
