package com.trabajo.posappseguras.controllers;

import com.trabajo.posappseguras.models.entity.Tipo_Pago;
import com.trabajo.posappseguras.models.services.ITipo_PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Tipo_PagoController {

    @Autowired
    private ITipo_PagoService tipoPagoService;

    @GetMapping("/tipo-pago")
    public List<Tipo_Pago> index() {
        return tipoPagoService.findAll();
    }

    @GetMapping("/tipo-pago/{id}")
    public Tipo_Pago show(@PathVariable Integer id) {
        return tipoPagoService.findById(id);
    }

    @PostMapping("/tipo-pago")
    @ResponseStatus(HttpStatus.CREATED)
    public Tipo_Pago create(@RequestBody Tipo_Pago tipoPago) {
        return tipoPagoService.save(tipoPago);
    }

    @PutMapping("/tipo-pago/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Tipo_Pago update(@RequestBody Tipo_Pago tipoPago, @PathVariable Integer id) {
        Tipo_Pago actual = tipoPagoService.findById(id);
        if (actual != null) {
            actual.setTipo(tipoPago.getTipo());
            actual.setDescrip(tipoPago.getDescrip());
            return tipoPagoService.save(actual);
        }
        return null;
    }

    @DeleteMapping("/tipo-pago/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        tipoPagoService.delete(id);
    }
}
