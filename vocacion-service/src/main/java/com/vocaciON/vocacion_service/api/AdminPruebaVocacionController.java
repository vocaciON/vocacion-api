package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.PreguntaDTO;
import com.vocaciON.vocacion_service.dto.PruebaVocacionDTO;
import com.vocaciON.vocacion_service.model.entity.PruebaVocacion;
import com.vocaciON.vocacion_service.service.AdminPruebaVocacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/pruebavocaciones")

public class AdminPruebaVocacionController {

    private final AdminPruebaVocacionService adminPruebaVocacionService;
    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<PruebaVocacionDTO>> getListaPruebaVocacion(){
        List<PruebaVocacionDTO> pruebaVocacions = adminPruebaVocacionService.getAll();
        return new ResponseEntity<>(pruebaVocacions, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<PruebaVocacionDTO> getPruebaVocacionById(@PathVariable("id") Long id){
        PruebaVocacionDTO  pruebaVocacion = adminPruebaVocacionService.findById(id);
        return new ResponseEntity<>(pruebaVocacion, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<PruebaVocacionDTO> create(@Valid @RequestBody PruebaVocacionDTO pruebaVocacionDTO){

        PruebaVocacionDTO createPruebaVocacion = adminPruebaVocacionService.create(pruebaVocacionDTO);
        return new ResponseEntity<>(createPruebaVocacion, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<PruebaVocacionDTO> update(@PathVariable("id") Long id,@Valid@RequestBody PruebaVocacionDTO pruebaVocacionDTO){

        PruebaVocacionDTO updatePruebaVocacion = adminPruebaVocacionService.update(id,pruebaVocacionDTO);
        return new ResponseEntity<>(updatePruebaVocacion, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        adminPruebaVocacionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
