package com.vocaciON.vocacion_service.api;


import com.vocaciON.vocacion_service.dto.ResultadoPruebaDTO;
import com.vocaciON.vocacion_service.dto.ResultadoPruebaDTO;
import com.vocaciON.vocacion_service.model.entity.ResultadoPrueba;
import com.vocaciON.vocacion_service.service.AdminResultadoPruebaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/restuldatoPruebas")
@PreAuthorize("hastRole('ADMIN')")

public class AdminResultadoPruebaController {

    private final AdminResultadoPruebaService adminResultadoPruebaService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<ResultadoPruebaDTO>> getListaResultadoPrueba(){
        List<ResultadoPruebaDTO> resultadoPruebas = adminResultadoPruebaService.getAll();
        return new ResponseEntity<>(resultadoPruebas, HttpStatus.OK); //ok = 200 //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<ResultadoPruebaDTO> getResultadoPruebaById(@PathVariable("id") Long id){
        ResultadoPruebaDTO resultadoPrueba = adminResultadoPruebaService.findById(id);
        return new ResponseEntity<ResultadoPruebaDTO>(resultadoPrueba, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<ResultadoPruebaDTO> create(@Valid @RequestBody ResultadoPruebaDTO resultadoPruebaDTO){

        ResultadoPruebaDTO createResultadoPrueba = adminResultadoPruebaService.create(resultadoPruebaDTO);
        return new ResponseEntity<>(createResultadoPrueba, HttpStatus.CREATED);
    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<ResultadoPruebaDTO> update(@PathVariable("id") Long id,@Valid@RequestBody ResultadoPruebaDTO resultadoPruebaDTO){

        ResultadoPruebaDTO updateResultadoPrueba = adminResultadoPruebaService.update(id,resultadoPruebaDTO);
        return new ResponseEntity<>(updateResultadoPrueba, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        adminResultadoPruebaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
