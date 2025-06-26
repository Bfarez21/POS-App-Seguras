package com.trabajo.posappseguras.models.services;

import com.trabajo.posappseguras.models.entity.Producto;
import java.util.List;

public interface IProductoService {
    List<Producto> findAll();
    Producto findById(Integer id);
    Producto save(Producto producto);
    void delete(Integer id);
}
