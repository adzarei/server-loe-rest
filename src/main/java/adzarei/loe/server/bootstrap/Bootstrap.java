package adzarei.loe.server.bootstrap;

import adzarei.loe.server.domain.Libro;
import adzarei.loe.server.respositories.ActaRepository;
import adzarei.loe.server.respositories.LibroRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private LibroRepository libroRepository;
    private ActaRepository actaRepository;

    public Bootstrap(LibroRepository libroRepository, ActaRepository actaRepository) {
        this.libroRepository = libroRepository;
        this.actaRepository = actaRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Libro libro1 = new Libro();
        libroRepository.save(libro1);

    }
}
