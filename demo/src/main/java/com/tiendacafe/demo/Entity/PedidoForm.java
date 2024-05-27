package com.tiendacafe.demo.Entity;

import java.util.List;

public class PedidoForm {
    private List<Long> productoIds;
    private List<Integer> cantidades;

    public List<Long> getProductoIds() {
        return productoIds;
    }

    public void setProductoIds(List<Long> productoIds) {
        this.productoIds = productoIds;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }
}
