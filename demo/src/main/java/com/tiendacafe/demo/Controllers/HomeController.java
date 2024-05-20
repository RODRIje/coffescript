package com.tiendacafe.demo.Controllers;

import com.tiendacafe.demo.Entity.PedidoForm;
import com.tiendacafe.demo.Entity.Producto;
import com.tiendacafe.demo.Service.imp.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IProductoService iProductoService;

    @GetMapping({"/index", "/home", "/"})
    public String index(Model model){
        List<Producto> productos = iProductoService.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("pedidoForm", new PedidoForm());
        return "home";
    }
}
