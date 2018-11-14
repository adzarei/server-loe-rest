package adzarei.loe.server.api.services;

import adzarei.loe.server.api.dtomodel.OrdenDto;
import adzarei.loe.server.api.mapper.OrdenMapper;
import adzarei.loe.server.api.respositories.OrdenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrdenServiceImpl implements OrdenService {

    OrdenRepository ordenRepository;
    OrdenMapper mapper;

    @Override
    public List<OrdenDto> getOrdenesByActaId(Long id) {
        return ordenRepository.getByActaId(id).stream()
                .map(mapper::ordenToOrdenDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createNewOrden( OrdenDto ordenDto) {
        ordenRepository.save(mapper.ordenDtoToOrden(ordenDto));
    }


}
