package adzarei.loe.server.api.respositories;

import adzarei.loe.server.api.domain.Acta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActaRepository extends JpaRepository<Acta,Long>, CrudRepository<Acta,Long> {
    List<Acta> getAllActasByLibroId(Long id);
}
