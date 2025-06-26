package com.trabajo.posappseguras.models.services.imp;

import com.trabajo.posappseguras.models.dao.IClasificacionDao;
import com.trabajo.posappseguras.models.entity.Clasificacion;
import com.trabajo.posappseguras.models.services.IClasificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClasificacionServiceImp implements IClasificacionService {

    @Autowired
    private IClasificacionDao clasificacionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Clasificacion> findAll() {
        return (List<Clasificacion>) clasificacionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Clasificacion findById(Integer id) {
        return clasificacionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Clasificacion save(Clasificacion clasificacion) {
        return clasificacionDao.save(clasificacion);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        clasificacionDao.deleteById(id);
    }
}
