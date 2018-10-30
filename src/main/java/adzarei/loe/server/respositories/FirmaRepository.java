package adzarei.loe.server.respositories;

import adzarei.loe.server.domain.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FirmaRepository extends JpaRepository<Firma,Long>, CrudRepository<Firma,Long> {
}
