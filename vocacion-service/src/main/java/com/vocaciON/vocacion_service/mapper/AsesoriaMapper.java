package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import org.hibernate.annotations.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class AsesoriaMapper {

    private final ModelMapper modelMapper;

    public AsesoriaMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public AsesoriaDTO toDTO(Asesoria asesoria) {
        return modelMapper.map(asesoria, AsesoriaDTO.class);
    }

    public Asesoria toEntity(AsesoriaDTO asesoriaDTO) {
        return modelMapper.map(asesoriaDTO, Asesoria.class);
    }

}
