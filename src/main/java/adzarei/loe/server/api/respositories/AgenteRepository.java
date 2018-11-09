package adzarei.loe.server.api.respositories;

import adzarei.loe.server.api.domain.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AgenteRepository extends JpaRepository<Agente,Long>, CrudRepository<Agente,Long> {
    List<Agente> getAgentesByLibroId(Long id);
}
