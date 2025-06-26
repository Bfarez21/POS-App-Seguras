package com.trabajo.posappseguras.models.services;

import com.trabajo.posappseguras.models.entity.Item_Factura;

import java.util.List;

public interface IItem_FacturaService {
    List<Item_Factura> findAll();
    Item_Factura findById(Integer id);
    Item_Factura save(Item_Factura itemFactura);
    void delete(Integer id);
}
