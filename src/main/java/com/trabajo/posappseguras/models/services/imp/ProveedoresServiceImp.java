package com.trabajo.posappseguras.models.services.imp;

import com.trabajo.posappseguras.models.dao.IProveedoresDao;
import com.trabajo.posappseguras.models.entity.Proveedores;
import com.trabajo.posappseguras.models.services.IProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedoresServiceImp implements IProveedoresService {

    @Autowired
    private IProveedoresDao proveedoresDao;

    @Override
    @Transactional(readOnly = true)
    public List<Proveedores> findAll() {
        return (List<Proveedores>) proveedoresDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedores findById(Integer id) {
        return proveedoresDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Proveedores save(Proveedores proveedor) {
        return proveedoresDao.save(proveedor);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        proveedoresDao.deleteById(id);
    }
}
