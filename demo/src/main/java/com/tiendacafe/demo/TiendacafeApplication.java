package com.tiendacafe.demo;

import com.tiendacafe.demo.Entity.Producto;
import com.tiendacafe.demo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendacafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendacafeApplication.class, args);
	}

}
