package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.ExpertoDTO;
import com.vocaciON.vocacion_service.model.entity.Experto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class ExpertoMapper {
    private final ModelMapper modelMapper;

    public ExpertoMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public ExpertoDTO toDTO(Experto experto) {
        return modelMapper.map(experto, ExpertoDTO.class);
    }

    public Experto toEntity(ExpertoDTO expertoDTO) {
        return modelMapper.map(expertoDTO, Experto.class);
    }
}
