package com.trabajo.posappseguras.models.services.imp;

import com.trabajo.posappseguras.models.dao.IItem_FacturaDao;
import com.trabajo.posappseguras.models.entity.Item_Factura;
import com.trabajo.posappseguras.models.services.IItem_FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Item_FacturaServiceImp implements IItem_FacturaService {

    @Autowired
    private IItem_FacturaDao itemFacturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Item_Factura> findAll() {
        return (List<Item_Factura>) itemFacturaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Item_Factura findById(Integer id) {
        return itemFacturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Item_Factura save(Item_Factura itemFactura) {
        return itemFacturaDao.save(itemFactura);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        itemFacturaDao.deleteById(id);
    }
}
