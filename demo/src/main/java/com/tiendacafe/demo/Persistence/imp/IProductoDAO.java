package com.tiendacafe.demo.Persistence.imp;

import com.tiendacafe.demo.Entity.Producto;
import com.tiendacafe.demo.Persistence.ProductoDAO;
import com.tiendacafe.demo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class IProductoDAO implements ProductoDAO{

    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public void descontarStockById(Long id, int cantidad) {
        productoRepository.descontarStockById(id, cantidad);
    }

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }
}
