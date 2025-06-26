package com.trabajo.posappseguras.models.services.imp;

import com.trabajo.posappseguras.models.dao.IProductoDao;
import com.trabajo.posappseguras.models.entity.Producto;
import com.trabajo.posappseguras.models.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>)productoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Integer id) {
        Optional<Producto> producto = productoDao.findById(id);
        return producto.orElse(null);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        productoDao.deleteById(id);
    }
}
