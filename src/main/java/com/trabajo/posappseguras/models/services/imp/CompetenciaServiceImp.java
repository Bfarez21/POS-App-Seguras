package com.trabajo.posappseguras.models.services.imp;

import com.trabajo.posappseguras.models.dao.ICompetenciaDao;
import com.trabajo.posappseguras.models.entity.Competencia;
import com.trabajo.posappseguras.models.services.ICompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompetenciaServiceImp implements ICompetenciaService {

    @Autowired
    private ICompetenciaDao competenciaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Competencia> findAll() {
        return (List<Competencia>) competenciaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Competencia findById(Integer id) {
        return competenciaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Competencia save(Competencia competencia) {
        return competenciaDao.save(competencia);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        competenciaDao.deleteById(id);
    }
}
