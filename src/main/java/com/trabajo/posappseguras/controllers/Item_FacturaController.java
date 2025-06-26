package com.trabajo.posappseguras.controllers;

import com.trabajo.posappseguras.models.entity.Item_Factura;
import com.trabajo.posappseguras.models.services.IItem_FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Item_FacturaController {

    @Autowired
    private IItem_FacturaService itemFacturaService;

    @GetMapping("/itemsfactura")
    public List<Item_Factura> index() {
        return itemFacturaService.findAll();
    }

    @GetMapping("/itemsfactura/{id}")
    public Item_Factura show(@PathVariable Integer id) {
        return itemFacturaService.findById(id);
    }

    @PostMapping("/itemsfactura")
    @ResponseStatus(HttpStatus.CREATED)
    public Item_Factura create(@RequestBody Item_Factura itemFactura) {
        return itemFacturaService.save(itemFactura);
    }

    @PutMapping("/itemsfactura/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Item_Factura update(@RequestBody Item_Factura itemFactura, @PathVariable Integer id) {
        Item_Factura itemActual = itemFacturaService.findById(id);
        if (itemActual != null) {
            itemActual.setIdFactura(itemFactura.getIdFactura());
            itemActual.setIdProducto(itemFactura.getIdProducto());
            itemActual.setCantidad(itemFactura.getCantidad());
            itemActual.setPrecio(itemFactura.getPrecio());
            itemActual.setSubtotal(itemFactura.getSubtotal());
            return itemFacturaService.save(itemActual);
        }
        return null; // Mejor lanzar excepción o manejar error 404
    }

    @DeleteMapping("/itemsfactura/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        itemFacturaService.delete(id);
    }
}
