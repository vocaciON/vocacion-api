package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.ContenidoEducativoDTO;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContenidoEducativoMapper {
    private final ModelMapper modelMapper;

    public ContenidoEducativoMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public ContenidoEducativoDTO toDTO(ContenidoEducativo contenidoEducativo) {
        return modelMapper.map(contenidoEducativo, ContenidoEducativoDTO.class);
    }

    public ContenidoEducativo toEntity(ContenidoEducativoDTO contenidoEducativoDTO) {
        return modelMapper.map(contenidoEducativoDTO, ContenidoEducativo.class);
    }
}
