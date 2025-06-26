package com.trabajo.posappseguras.controllers;

import com.trabajo.posappseguras.models.entity.Rol;
import com.trabajo.posappseguras.models.services.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping("/roles")
    public List<Rol> index() {
        return rolService.findAll();
    }

    @GetMapping("/roles/{id}")
    public Rol show(@PathVariable Integer id) {
        return rolService.findById(id);
    }

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol create(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    @PutMapping("/roles/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol update(@RequestBody Rol rol, @PathVariable Integer id) {
        Rol rolActual = rolService.findById(id);
        if (rolActual != null) {
            rolActual.setRol(rol.getRol());
            rolActual.setEstado(rol.getEstado());
            return rolService.save(rolActual);
        }
        return null; // Alternativamente: lanzar una excepción de recurso no encontrado
    }

    @DeleteMapping("/roles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        rolService.delete(id);
    }
}
