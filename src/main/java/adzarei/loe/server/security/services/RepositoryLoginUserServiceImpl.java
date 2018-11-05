package adzarei.loe.server.security.services;

import adzarei.loe.server.security.repositories.LoginUserRepository;
import adzarei.loe.server.security.model.LoginUser;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class RepositoryLoginUserServiceImpl implements LoginUserService {

    @NotNull private final LoginUserRepository loginUserRepository;

    public RepositoryLoginUserServiceImpl(@NotNull LoginUserRepository loginUserRepository) {
        this.loginUserRepository = loginUserRepository;
    }

    @Override
    public Optional<LoginUser> saveLoginUser(LoginUser loginUser) {
        return Optional.of(loginUserRepository.save(loginUser));
    }

    @Override
    public Optional<LoginUser> findLoginUser(Long id) {

        return loginUserRepository.findById(id);
    }

    @Override
    public Optional<LoginUser> findLoginUserByUsername(String username) {
        return loginUserRepository.findAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    @Override
    public Optional<LoginUser> patchLoginUser(Long id, LoginUser user) {
        loginUserRepository.findById(id)
                .map(repoUser -> {

                    if (user.getId() != null)
                        repoUser.setId(user.getId());

                    if(user.getPassword() != null)
                        repoUser.setPassword(user.getPassword());

                    if (user.getTokens() != null)
                        repoUser.setPassword(user.getPassword());

                    return loginUserRepository.save(repoUser);
                });


        return Optional.empty();
    }
}
