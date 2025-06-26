package com.trabajo.posappseguras.controllers;

import com.trabajo.posappseguras.models.entity.Factura;
import com.trabajo.posappseguras.models.services.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @GetMapping("/facturas")
    public List<Factura> index() {
        return facturaService.findAll();
    }

    @GetMapping("/facturas/{id}")
    public Factura show(@PathVariable Integer id) {
        return facturaService.findById(id);
    }

    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura create(@RequestBody Factura factura) {
        return facturaService.save(factura);
    }

    @PutMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura update(@RequestBody Factura factura, @PathVariable Integer id) {
        Factura facturaActual = facturaService.findById(id);
        if (facturaActual != null) {
            facturaActual.setRuc(factura.getRuc());
            facturaActual.setIdPersona(factura.getIdPersona());
            facturaActual.setFecha(factura.getFecha());
            facturaActual.setIdTipoPago(factura.getIdTipoPago());
            facturaActual.setDescuento(factura.getDescuento());
            facturaActual.setTotal(factura.getTotal());
            facturaActual.setItems(factura.getItems());
            return facturaService.save(facturaActual);
        }
        return null; // Mejor manejar error 404 o lanzar excepción
    }

    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        facturaService.delete(id);
    }
}
