package adzarei.loe.server.security.repositories;

import adzarei.loe.server.security.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LoginUserRepository extends JpaRepository<LoginUser,Long>, CrudRepository<LoginUser,Long> {
}
