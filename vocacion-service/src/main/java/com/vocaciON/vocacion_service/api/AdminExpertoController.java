package com.vocaciON.vocacion_service.api;


import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.ExpertoDTO;
import com.vocaciON.vocacion_service.model.entity.Experto;
import com.vocaciON.vocacion_service.service.AdminExpertoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/expertos") // identificador de recurso universar o unico
public class AdminExpertoController {

    //Dato importante
    //En un controlador no se inyectan los repositorys
    // controlador resive inyeccion de los servicios y el servicio recibe la inyeccion de los repositorys

    //Aqui tengo que inyectar las interface
    private final AdminExpertoService adminExpertoService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<ExpertoDTO>> getListaExperto(){
        List<ExpertoDTO> experto = adminExpertoService.getAll();
        return new ResponseEntity<>(experto, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<ExpertoDTO> getExpertoById(@PathVariable("id") Long id){
        ExpertoDTO experto = adminExpertoService.findById(id);
        return new ResponseEntity<>(experto, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<ExpertoDTO> create(@Valid @RequestBody ExpertoDTO expertoDTO){

        ExpertoDTO createExperto = adminExpertoService.create(expertoDTO);
        return new ResponseEntity<>(createExperto, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<ExpertoDTO> update(@PathVariable("id") Long id,@Valid@RequestBody ExpertoDTO expertoDTO){

        ExpertoDTO updateExperto = adminExpertoService.update(id,expertoDTO);
        return new ResponseEntity<>(updateExperto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        adminExpertoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
