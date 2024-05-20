package com.tiendacafe.demo.Service.imp;

import com.tiendacafe.demo.Entity.Producto;
import com.tiendacafe.demo.Repository.ProductoRepository;
import com.tiendacafe.demo.Service.ProductoService;
import com.tiendacafe.demo.Persistence.imp.IProductoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IProductoService implements ProductoService {
    @Autowired
    private IProductoDAO iProductoDAO;
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional
    public boolean descontarStockById(Long id, int cantidad) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        if (producto.getCantidad() < cantidad) {
            return false; // No hay suficiente stock
        }
        productoRepository.descontarStockById(id, cantidad);
        return true;
    }

    @Override
    public List<Producto> findAll() {
        return iProductoDAO.findAll();
    }
    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

}
