package adzarei.loe.server.security.services;

import adzarei.loe.server.security.model.LoginUser;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Primary
@Service
public class InMemoryLoginUserService implements LoginUserService {

    Map<String, LoginUser> users = new HashMap<>();

    @Override
    public LoginUser saveLoginUser(final LoginUser user) {
        return users.put(user.getId(), user);
    }

    @Override
    public Optional<LoginUser> findLoginUser(final String id) {
        return ofNullable(users.get(id));
    }

    @Override
    public Optional<LoginUser> findLoginUserByUsername(final String username) {
        return users
                .values()
                .stream()
                .filter(u -> Objects.equals(username, u.getUsername()))
                .findFirst();
    }
}
