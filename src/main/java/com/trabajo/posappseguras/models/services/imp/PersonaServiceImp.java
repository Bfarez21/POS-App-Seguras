package com.trabajo.posappseguras.models.services.imp;

import com.trabajo.posappseguras.models.dao.IPersonaDao;
import com.trabajo.posappseguras.models.entity.Persona;
import com.trabajo.posappseguras.models.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImp implements IPersonaService {

    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return personaDao.save(persona);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        personaDao.deleteById(id);
    }
}
