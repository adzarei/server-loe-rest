package adzarei.loe.server.api.services;

import adzarei.loe.server.api.dtomodel.AgenteDto;
import adzarei.loe.server.api.mapper.AgenteMapper;
import adzarei.loe.server.api.respositories.AgenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AgenteServiceImpl implements AgenteService {

    private AgenteRepository repository;
    private AgenteMapper mapper;

    @Override
    public List<AgenteDto> getAgentesByLibroId(Long id) {

        return this.repository.getAgentesByLibroId(id)
                .stream()
                .map(mapper :: agenteToAgenteDto)
                .collect(Collectors.toList());
    }
}
