package com.trabajo.posappseguras.models.services;

import com.trabajo.posappseguras.models.entity.Tipo_Pago;

import java.util.List;

public interface ITipo_PagoService {

    List<Tipo_Pago> findAll();
    Tipo_Pago findById(Integer id);
    Tipo_Pago save(Tipo_Pago tipoPago);
    void delete(Integer id);
    //Tipo_Pago findByTipo(String tipo);
    //List<Tipo_Pago> findByDescripcion(String descripcion);
    //List<Tipo_Pago> findAllActive();
}
