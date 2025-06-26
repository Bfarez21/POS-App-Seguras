package com.trabajo.posappseguras.models.services.imp;

import com.trabajo.posappseguras.models.dao.IRolDao;
import com.trabajo.posappseguras.models.entity.Rol;
import com.trabajo.posappseguras.models.services.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolServiceImp implements IRolService {

    @Autowired
    private IRolDao rolDao;

    @Override
    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return (List<Rol>) rolDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Rol findById(Integer id) {
        return rolDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Rol save(Rol rol) {
        return rolDao.save(rol);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        rolDao.deleteById(id);
    }
}
