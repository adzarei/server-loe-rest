package adzarei.loe.server.security.repositories;

import adzarei.loe.server.security.model.ActiveToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ActiveTokenRepository extends JpaRepository<ActiveToken,Long>, CrudRepository<ActiveToken,Long> {

}
