package adzarei.loe.server.api.respositories;

import adzarei.loe.server.api.domain.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrdenRepository extends JpaRepository<Orden,Long>, CrudRepository<Orden,Long> {
}
