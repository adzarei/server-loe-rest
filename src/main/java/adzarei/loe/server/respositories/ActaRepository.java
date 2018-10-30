package adzarei.loe.server.respositories;

import adzarei.loe.server.domain.Acta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ActaRepository extends JpaRepository<Acta,Long>, CrudRepository<Acta,Long> {
}
