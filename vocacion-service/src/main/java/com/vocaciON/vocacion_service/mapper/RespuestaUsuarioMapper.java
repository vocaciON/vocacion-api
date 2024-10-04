package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.RespuestaUsuarioDTO;
import com.vocaciON.vocacion_service.model.entity.RespuestaUsuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class RespuestaUsuarioMapper {
    private final ModelMapper modelMapper;

    public RespuestaUsuarioMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public RespuestaUsuarioDTO toDTO(RespuestaUsuario respuestaUsuario) {
        return modelMapper.map(respuestaUsuario, RespuestaUsuarioDTO.class);
    }

    public RespuestaUsuario toEntity(RespuestaUsuarioDTO respuestaUsuarioDTO) {
        return modelMapper.map(respuestaUsuarioDTO, RespuestaUsuario.class);
    }
}


