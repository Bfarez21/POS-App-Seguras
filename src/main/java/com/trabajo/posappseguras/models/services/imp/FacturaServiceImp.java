package com.trabajo.posappseguras.models.services.imp;

import com.trabajo.posappseguras.models.dao.IFacturaDao;
import com.trabajo.posappseguras.models.entity.Factura;
import com.trabajo.posappseguras.models.services.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaServiceImp implements IFacturaService {

    @Autowired
    private IFacturaDao facturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Factura> findAll() {
        return (List<Factura>) facturaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findById(Integer id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Factura save(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        facturaDao.deleteById(id);
    }
}
