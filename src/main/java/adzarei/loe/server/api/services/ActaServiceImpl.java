package adzarei.loe.server.api.services;

import adzarei.loe.server.api.dtomodel.ActaDto;
import adzarei.loe.server.api.respositories.ActaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ActaServiceImpl implements ActaService {

    private ActaRepository repository;

    @Override
    public List<ActaDto> getActasByLibroId(Long id) {
        return repository.getAllActasByLibroId(id);
    }
}
