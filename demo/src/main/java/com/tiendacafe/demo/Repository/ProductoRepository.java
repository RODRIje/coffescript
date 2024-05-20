package com.tiendacafe.demo.Repository;

import com.tiendacafe.demo.Entity.Producto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    //Descontar el producto consumido del stock por ID
    @Transactional
    @Modifying
    @Query("UPDATE Producto p SET p.cantidad = p.cantidad - :cantidad WHERE p.id = :id")
    void descontarStockById(Long id, int cantidad);

    //Buscar todos los productos
    List<Producto> findAll();
}
