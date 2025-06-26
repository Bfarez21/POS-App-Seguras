package com.trabajo.posappseguras.models.services.imp;

import com.trabajo.posappseguras.models.dao.ITipo_PagoDao;
import com.trabajo.posappseguras.models.entity.Tipo_Pago;
import com.trabajo.posappseguras.models.services.ITipo_PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Tipo_PagoServiceImp implements ITipo_PagoService {

    @Autowired
    private ITipo_PagoDao tipoPagoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Tipo_Pago> findAll() {
        return (List<Tipo_Pago>) tipoPagoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Tipo_Pago findById(Integer id) {
        return tipoPagoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Tipo_Pago save(Tipo_Pago tipoPago) {
        return tipoPagoDao.save(tipoPago);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        tipoPagoDao.deleteById(id);
    }
}
