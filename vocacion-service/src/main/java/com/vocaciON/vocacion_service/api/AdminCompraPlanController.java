package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.CompraPlanCreateDTO;
import com.vocaciON.vocacion_service.dto.CompraPlanDTO;
import com.vocaciON.vocacion_service.service.AdminCompraPlanService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor

@RequestMapping("/admin/compraPlanes")
public class AdminCompraPlanController {
    private final AdminCompraPlanService adminCompraPlanService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping()
    public ResponseEntity<List<CompraPlanDTO>> getListaCompraPlan() {
        List<CompraPlanDTO> compraPlan = adminCompraPlanService.getAll();
        System.out.println("Lista de CompraPlan: " + compraPlan); // Log para verificar los datos
        return new ResponseEntity<>(compraPlan, HttpStatus.OK);
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<CompraPlanDTO> getCompraPlanById(@PathVariable("id") Long id){
        CompraPlanDTO compraPlan = adminCompraPlanService.findById(id);
        return new ResponseEntity<>(compraPlan, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<CompraPlanDTO> create(@Valid @RequestBody CompraPlanCreateDTO compraPlanCreateDTO){


        CompraPlanDTO createCompraPlan = adminCompraPlanService.create(compraPlanCreateDTO);
        return new ResponseEntity<>(createCompraPlan, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<CompraPlanDTO> update(@PathVariable("id") Long id,@Valid@RequestBody CompraPlanCreateDTO compraPlanCreateDTO){

        CompraPlanDTO updateExperto = adminCompraPlanService.update(id,compraPlanCreateDTO);
        return new ResponseEntity<>(updateExperto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        adminCompraPlanService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
