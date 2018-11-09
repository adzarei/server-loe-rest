package adzarei.loe.server.api.services;

import adzarei.loe.server.api.dtomodel.ActaDto;
import adzarei.loe.server.api.mapper.ActaMapper;
import adzarei.loe.server.api.respositories.ActaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ActaServiceImpl implements ActaService {

    private ActaRepository repository;
    private ActaMapper mapper;

    @Override
    public List<ActaDto> getActasByLibroId(Long id) {
        return repository.getAllActasByLibroId(id).stream()
                .map( mapper :: actaToActaDto)
                .collect(Collectors.toList());
    }
}
