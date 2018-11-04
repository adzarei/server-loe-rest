package adzarei.loe.server.security.services;

import adzarei.loe.server.security.model.LoginUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepositoryLoginUserService implements LoginUserService {

    @Override
    public LoginUser saveLoginUser(LoginUser loginUser) {
        return null;
    }

    @Override
    public Optional<LoginUser> findLoginUser(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<LoginUser> findLoginUserByUsername(String username) {
        return Optional.empty();
    }
}
