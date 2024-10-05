package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.PruebaVocacionDTO;
import com.vocaciON.vocacion_service.model.entity.PruebaVocacion;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class PruebaVocacionMapper {
    private final ModelMapper modelMapper;

    public PruebaVocacionMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    public PruebaVocacionDTO toDTO(PruebaVocacion pruebaVocacion) {
        return modelMapper.map(pruebaVocacion, PruebaVocacionDTO.class);
    }

    public PruebaVocacion toEntity(PruebaVocacionDTO pruebaVocacionDTO) {
        return modelMapper.map(pruebaVocacionDTO, PruebaVocacion.class);
    }
}
