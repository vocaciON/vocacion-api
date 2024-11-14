package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.ExpertoCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.ExpertoDTO;
import com.vocaciON.vocacion_service.service.AdminAsesoriaService;
import com.vocaciON.vocacion_service.service.AdminExpertoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/experto")
@RequiredArgsConstructor
@PreAuthorize("hastRole('ADMIN')")

public class AdminExpertoController {
    private final AdminExpertoService adminExpertoService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<ExpertoDTO>> getListaExperto(){
        List<ExpertoDTO> expertos = adminExpertoService.getAll();
        return new ResponseEntity<>(expertos, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<ExpertoDTO> getExpertoById(@PathVariable("id") Long id){
        ExpertoDTO experto = adminExpertoService.findById(id);
        return new ResponseEntity<>(experto, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<ExpertoDTO> create(@Valid @RequestBody ExpertoCreateUpdateDTO expertoCreateUpdateDTO){


        ExpertoDTO createExperto = adminExpertoService.create(expertoCreateUpdateDTO);
        return new ResponseEntity<>(createExperto, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<ExpertoDTO> update(@PathVariable("id") Long id,@Valid@RequestBody ExpertoCreateUpdateDTO  expertoCreateUpdateDTO){

        ExpertoDTO updateExperto = adminExpertoService.update(id,expertoCreateUpdateDTO);
        return new ResponseEntity<>(updateExperto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        adminExpertoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
