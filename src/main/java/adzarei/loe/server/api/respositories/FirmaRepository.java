package adzarei.loe.server.api.respositories;

import adzarei.loe.server.api.domain.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FirmaRepository extends JpaRepository<Firma,Long>, CrudRepository<Firma,Long> {
}
