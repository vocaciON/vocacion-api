package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.CompraPlanCreateDTO;

import com.vocaciON.vocacion_service.dto.CompraPlanDTO;
import com.vocaciON.vocacion_service.model.entity.CompraPlan;
import com.vocaciON.vocacion_service.model.entity.Experto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class CompraPlanMapper {
    private final ModelMapper modelMapper;

    public CompraPlanMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;

    }

    public CompraPlanDTO toDTO(CompraPlan compraPlan) {
        System.out.println("Mapeando CompraPlan a DTO: " + compraPlan); // Log de depuración
        return modelMapper.map(compraPlan, CompraPlanDTO.class);
    }

    public CompraPlan toEntity(CompraPlanCreateDTO compraPlanCreateDTO) {
        return modelMapper.map(compraPlanCreateDTO, CompraPlan.class);
    }

    public CompraPlanCreateDTO toCompraPlanCreateDTO(CompraPlan compraPlan) {
        return modelMapper.map(compraPlan, CompraPlanCreateDTO.class);
    }
}
