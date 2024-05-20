package com.tiendacafe.demo.Persistence;

import com.tiendacafe.demo.Entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoDAO {
    //Descontar el producto consumido del stock por ID
    void descontarStockById(Long id, int cantidad);
    //Listar todos los productos
    List<Producto> findAll();

}
