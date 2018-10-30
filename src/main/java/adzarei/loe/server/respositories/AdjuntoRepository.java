package adzarei.loe.server.respositories;

import adzarei.loe.server.domain.Adjunto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AdjuntoRepository extends JpaRepository<Adjunto,Long>, CrudRepository<Adjunto,Long> {
}
