package adzarei.loe.server.api.respositories;

import adzarei.loe.server.api.domain.Asistente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AsistenteRepository extends JpaRepository<Asistente,Long>, CrudRepository<Asistente,Long> {
}
