package com.trabajo.posappseguras.models.services;

import com.trabajo.posappseguras.models.entity.Factura;

import java.util.List;

public interface IFacturaService {
    List<Factura> findAll();
    Factura findById(Integer id);
    Factura save(Factura factura);
    void delete(Integer id);
}
