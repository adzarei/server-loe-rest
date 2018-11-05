package adzarei.loe.server.api.respositories;

import adzarei.loe.server.api.domain.Adjunto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdjuntoRepository extends JpaRepository<Adjunto,Long>, CrudRepository<Adjunto,Long> {
}
