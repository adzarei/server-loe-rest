package adzarei.loe.server.respositories;

import adzarei.loe.server.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends JpaRepository<Libro,Long>, CrudRepository<Libro,Long> {


}
