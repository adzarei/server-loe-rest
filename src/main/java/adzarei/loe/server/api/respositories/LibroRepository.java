package adzarei.loe.server.api.respositories;

import adzarei.loe.server.api.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends JpaRepository<Libro,Long>, CrudRepository<Libro,Long> {


}
