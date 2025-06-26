package com.trabajo.posappseguras.controllers;

import com.trabajo.posappseguras.models.entity.Proveedores;
import com.trabajo.posappseguras.models.services.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProveedoresController {

    @Autowired
    private IProveedoresService proveedoresService;

    @GetMapping("/proveedores")
    public List<Proveedores> index() {
        return proveedoresService.findAll();
    }

    @GetMapping("/proveedores/{id}")
    public Proveedores show(@PathVariable Integer id) {
        return proveedoresService.findById(id);
    }

    @PostMapping("/proveedores")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedores create(@RequestBody Proveedores proveedor) {
        return proveedoresService.save(proveedor);
    }

    @PutMapping("/proveedores/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedores update(@RequestBody Proveedores proveedor, @PathVariable Integer id) {
        Proveedores proveedorActual = proveedoresService.findById(id);
        if (proveedorActual != null) {
            proveedorActual.setRuc(proveedor.getRuc());
            proveedorActual.setTelefono(proveedor.getTelefono());
            proveedorActual.setPais(proveedor.getPais());
            proveedorActual.setCorreo(proveedor.getCorreo());
            proveedorActual.setMoneda(proveedor.getMoneda());
            return proveedoresService.save(proveedorActual);
        }
        return null; // Recomendado: lanzar una excepción o retornar 404
    }

    @DeleteMapping("/proveedores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        proveedoresService.delete(id);
    }
}
