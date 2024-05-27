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
        List<Producto> productos = new ArrayList<>();
        List<Integer> cantidades = pedidoForm.getCantidades();
        double precioTotal = 0;

        for (int i = 0; i < pedidoForm.getProductoIds().size(); i++) {
            Long productoId = pedidoForm.getProductoIds().get(i);
            Integer cantidad = pedidoForm.getCantidades().get(i);

            Producto producto = iProductoService.findById(productoId);
            if (producto.getCantidad() < cantidad) {
                model.addAttribute("error", "No hay suficiente stock para el producto: " + producto.getProducto());
                return "home";
            }

            iProductoService.descontarStockById(productoId, cantidad);
            productos.add(producto);
            precioTotal += producto.getPrecio() * cantidad;
        }

        model.addAttribute("productos", productos);
        model.addAttribute("cantidades", cantidades);
        model.addAttribute("precioTotal", precioTotal);
        model.addAttribute("pedidoRealizado", true);

        return "home";
    }
}
