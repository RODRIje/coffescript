package com.tiendacafe.demo.Service;

import com.tiendacafe.demo.Entity.Producto;

import java.util.List;

public interface ProductoService {
    //Descontar el producto consumido del stock por ID
    boolean descontarStockById(Long id, int cantidad);

    //Listar todos los productos
     List<Producto> findAll();
    Producto findById(Long id);
}
