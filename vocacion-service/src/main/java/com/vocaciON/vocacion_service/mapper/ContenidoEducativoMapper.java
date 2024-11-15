package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.ContenidoEducativoCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.ContenidoEducativoDTO;
import com.vocaciON.vocacion_service.dto.ContenidoEducativoDetailsDTO;
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

    public ContenidoEducativoDetailsDTO toDetailsDTO(ContenidoEducativo contenidoEducativo) {
        return modelMapper.map(contenidoEducativo, ContenidoEducativoDetailsDTO.class);
    }

    public ContenidoEducativo toEntity(ContenidoEducativoCreateUpdateDTO contenidoEducativoCreateUpdateDTO) {
        return modelMapper.map(contenidoEducativoCreateUpdateDTO, ContenidoEducativo.class);
    }

    public ContenidoEducativoCreateUpdateDTO toCreateUpdateDTO(ContenidoEducativo contenidoEducativo) {
        return modelMapper.map(contenidoEducativo, ContenidoEducativoCreateUpdateDTO.class);
    }
}
