package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.PerfilDTO;
import com.vocaciON.vocacion_service.model.entity.Perfil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class PerfilMapper {
    private final ModelMapper modelMapper;

    public PerfilMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public PerfilDTO toDTO(Perfil perfil) {
        return modelMapper.map(perfil, PerfilDTO.class);
    }

    public Perfil toEntity(PerfilDTO perfilDTO) {
        return modelMapper.map(perfilDTO, Perfil.class);
    }
}
