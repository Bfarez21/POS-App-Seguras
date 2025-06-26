package com.trabajo.posappseguras.controllers;

import com.trabajo.posappseguras.models.entity.Producto;
import com.trabajo.posappseguras.models.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/producto")
    public List<Producto> index() {
        return productoService.findAll();
    }

    @GetMapping("/producto/{id}")
    public Producto show(@PathVariable Integer id) {
        return productoService.findById(id);
    }

    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto create(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto update(@RequestBody Producto producto, @PathVariable Integer id) {
        Producto productoActual = productoService.findById(id);

        if (productoActual != null) {
            productoActual.setStock(producto.getStock());
            productoActual.setPrecioUnitario(producto.getPrecioUnitario());
            productoActual.setUnidad(producto.getUnidad());
            productoActual.setIdClasificacion(producto.getIdClasificacion());
            productoActual.setIdProveedor(producto.getIdProveedor());
            productoActual.setIva(producto.getIva());
            // No se actualizan las relaciones automáticas (clasificacion, proveedor),
            // porque se gestionan por los ids, y JPA las maneja por separado.

            return productoService.save(productoActual);
        }

        return null; // o lanzar excepción/notFound si prefieres
    }

    @DeleteMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        productoService.delete(id);
    }
}
