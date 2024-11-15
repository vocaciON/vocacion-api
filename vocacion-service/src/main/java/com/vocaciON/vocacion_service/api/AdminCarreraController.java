package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.CarreraDTO;

import com.vocaciON.vocacion_service.service.AdminCarreraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/carreras")

public class AdminCarreraController {

    private final AdminCarreraService adminCarreraService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<CarreraDTO>> getListaCarrera(){
        List<CarreraDTO> carreras = adminCarreraService.getAll();
        return new ResponseEntity<>(carreras, HttpStatus.OK); //ok = 200
    }


    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<CarreraDTO> getCarreraById(@PathVariable("id") Long id){
        CarreraDTO carrera = adminCarreraService.findById(id);
        return new ResponseEntity<>(carrera, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<CarreraDTO> create(@Valid @RequestBody CarreraDTO carreraDTO){

        CarreraDTO createCarrera = adminCarreraService.create(carreraDTO);
        return new ResponseEntity<>(createCarrera, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<CarreraDTO> update(@PathVariable("id") Long id,@Valid@RequestBody CarreraDTO carreraDTO){

        CarreraDTO updateCarrera = adminCarreraService.update(id,carreraDTO);
        return new ResponseEntity<>(updateCarrera, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        adminCarreraService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
