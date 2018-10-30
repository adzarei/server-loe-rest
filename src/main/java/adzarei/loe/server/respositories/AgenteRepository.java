package adzarei.loe.server.respositories;

import adzarei.loe.server.domain.Agente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AgenteRepository extends JpaRepository<Agente,Long>, CrudRepository<Agente,Long> {
}
