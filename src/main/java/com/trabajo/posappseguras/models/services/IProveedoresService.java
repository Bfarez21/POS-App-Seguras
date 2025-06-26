package com.trabajo.posappseguras.models.services;

import com.trabajo.posappseguras.models.entity.Proveedores;

import java.util.List;

public interface IProveedoresService {
    List<Proveedores> findAll();
    Proveedores findById(Integer id);
    Proveedores save(Proveedores proveedores);
    void delete(Integer id);
}
