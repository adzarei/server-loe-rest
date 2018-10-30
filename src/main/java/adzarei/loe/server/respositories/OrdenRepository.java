package adzarei.loe.server.respositories;

import adzarei.loe.server.domain.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrdenRepository extends JpaRepository<Orden,Long>, CrudRepository<Orden,Long> {
}
