package adzarei.loe.server.security.repositories;

import adzarei.loe.server.security.model.ActiveToken;
import adzarei.loe.server.security.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoginUserRepository extends JpaRepository<LoginUser,Long>, CrudRepository<LoginUser,Long> {

        LoginUser findLoginUserByTokens(List<ActiveToken> tokens);
}
