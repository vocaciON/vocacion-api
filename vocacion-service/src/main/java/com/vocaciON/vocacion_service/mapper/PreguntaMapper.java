package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.PreguntaDTO;
import com.vocaciON.vocacion_service.model.entity.Pregunta;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class PreguntaMapper {
    private final ModelMapper modelMapper;

    public PreguntaMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public PreguntaDTO toDTO(Pregunta pregunta) {
        return modelMapper.map(pregunta, PreguntaDTO.class);
    }

    public Pregunta toEntity(PreguntaDTO preguntaDTO) {
        return modelMapper.map(preguntaDTO, Pregunta.class);
    }
}


