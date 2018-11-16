package adzarei.loe.server.api.services;

import adzarei.loe.server.api.domain.Acta;
import adzarei.loe.server.api.dtomodel.ActaDto;
import adzarei.loe.server.api.mapper.ActaMapper;
import adzarei.loe.server.api.respositories.ActaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

    @Override
    public int getNextNumHoja(Long libroId) {
        Acta lastActa =repository.getTopActaByLibroIdOrderByNumHojaDesc(libroId);
        return lastActa.getNumHoja() + 1;
    }


    @Override
    public ActaDto getActaById(Long id) {
        return mapper.actaToActaDto(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException()));
    }

    @Override
    public Long newActa(Acta acta) {

        return repository.save(acta).getId();
    }

}
