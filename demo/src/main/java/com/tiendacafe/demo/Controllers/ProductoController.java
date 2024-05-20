package com.tiendacafe.demo.Controllers;

import com.tiendacafe.demo.Entity.PedidoForm;
import com.tiendacafe.demo.Entity.Producto;
import com.tiendacafe.demo.Service.imp.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/views/productos")
public class ProductoController {

    @Autowired
    private IProductoService iProductoService;

    @GetMapping("/")
    public String listarProductos(Model model){
        List<Producto> listarProductos = iProductoService.findAll();

        model.addAttribute("titulo","Lista de productos");
        model.addAttribute("productos", listarProductos);
        return "/views/productos/listar";
    }

    @PostMapping("/pedido")
    public String realizarPedido(PedidoForm pedidoForm, Model model) {
        Producto producto = iProductoService.findById(pedidoForm.getProductoId());

        if (producto == null) {
            model.addAttribute("error", "Producto no encontrado.");
            return "home";
        }

        boolean success = iProductoService.descontarStockById(pedidoForm.getProductoId(), pedidoForm.getCantidad());

        if (!success) {
            model.addAttribute("error", "No hay suficiente stock para el producto seleccionado.");
            return "home";
        }

        model.addAttribute("producto", producto);
        model.addAttribute("cantidad", pedidoForm.getCantidad());
        model.addAttribute("precioTotal", producto.getPrecio() * pedidoForm.getCantidad());
        model.addAttribute("pedidoRealizado", true);

        return "home";
    }
}
