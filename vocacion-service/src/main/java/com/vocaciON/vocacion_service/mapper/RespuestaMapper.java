package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.RespuestaDTO;
import com.vocaciON.vocacion_service.model.entity.Respuesta;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class RespuestaMapper {
    private final ModelMapper modelMapper;

    public RespuestaMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public RespuestaDTO toDTO(Respuesta respuesta) {
        return modelMapper.map(respuesta, RespuestaDTO.class);
    }

    public Respuesta toEntity(RespuestaDTO respuestaDTO) {
        return modelMapper.map(respuestaDTO, Respuesta.class);
    }
}


