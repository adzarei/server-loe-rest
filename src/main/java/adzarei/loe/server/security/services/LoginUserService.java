package adzarei.loe.server.security.services;


import adzarei.loe.server.security.model.LoginUser;

import java.util.Optional;

public interface LoginUserService {

     LoginUser saveLoginUser(LoginUser loginUser);
     Optional<LoginUser> findLoginUser(Long id);
     Optional<LoginUser> findLoginUserByUsername(String username);

}
