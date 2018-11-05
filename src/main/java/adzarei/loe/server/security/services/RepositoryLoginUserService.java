package adzarei.loe.server.security.services;

import adzarei.loe.server.security.repositories.LoginUserRepository;
import adzarei.loe.server.security.model.LoginUser;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@Primary
public class RepositoryLoginUserService implements LoginUserService {

    @NotNull LoginUserRepository loginUserRepository;

    @Override
    public LoginUser saveLoginUser(LoginUser loginUser) {
        return loginUserRepository.save(loginUser);
    }

    @Override
    public Optional<LoginUser> findLoginUser(Long id) {

        return loginUserRepository.findById(id);
    }

    @Override
    public Optional<LoginUser> findLoginUserByUsername(String username) {
        return Optional.empty();
    }
}
