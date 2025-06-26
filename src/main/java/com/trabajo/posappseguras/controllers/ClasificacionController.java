package com.trabajo.posappseguras.controllers;

import com.trabajo.posappseguras.models.entity.Clasificacion;
import com.trabajo.posappseguras.models.services.IClasificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ClasificacionController {

    @Autowired
    private IClasificacionService clasificacionService;

    @GetMapping("/clasificacion")
    public List<Clasificacion> index() {
        return clasificacionService.findAll();
    }

    @GetMapping("/clasificacion/{id}")
    public Clasificacion show(@PathVariable Integer id) {
        return clasificacionService.findById(id);
    }

    @PostMapping("/clasificacion")
    @ResponseStatus(HttpStatus.CREATED)
    public Clasificacion create(@RequestBody Clasificacion clasificacion) {
        return clasificacionService.save(clasificacion);
    }

    @PutMapping("/clasificacion/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Clasificacion update(@RequestBody Clasificacion clasificacion, @PathVariable Integer id) {
        Clasificacion clasificacionActual = clasificacionService.findById(id);

        if (clasificacionActual != null) {
            clasificacionActual.setGrupo(clasificacion.getGrupo());
            // No actualizamos la lista de productos desde aquí para evitar sobrecarga
            return clasificacionService.save(clasificacionActual);
        }
        return null; // Podrías lanzar excepción o retornar un 404 si no existe
    }

    @DeleteMapping("/clasificacion/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        clasificacionService.delete(id);
    }
}
