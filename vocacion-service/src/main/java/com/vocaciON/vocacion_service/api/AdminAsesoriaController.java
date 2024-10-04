package com.vocaciON.vocacion_service.api;


import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import com.vocaciON.vocacion_service.service.AdminAsesoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/asesorias")

public class AdminAsesoriaController {

    private final AdminAsesoriaService adminAsesoriaService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<AsesoriaDTO>> getListaAsesoria(){
        List<AsesoriaDTO> asesorias = adminAsesoriaService.getAll();
        return new ResponseEntity<>(asesorias, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<AsesoriaDTO> getAsesoriaById(@PathVariable("id") Long id){
        AsesoriaDTO asesoria = adminAsesoriaService.findById(id);
        return new ResponseEntity<>(asesoria, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<AsesoriaDTO> create(@Valid @RequestBody AsesoriaDTO asesoriaDTO){

        AsesoriaDTO createAsesoria = adminAsesoriaService.create(asesoriaDTO);
        return new ResponseEntity<>(createAsesoria, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<AsesoriaDTO> update(@PathVariable("id") Long id,@Valid@RequestBody AsesoriaDTO asesoriaDTO){

        AsesoriaDTO updateAsesoria = adminAsesoriaService.update(id,asesoriaDTO);
        return new ResponseEntity<>(updateAsesoria, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        adminAsesoriaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
