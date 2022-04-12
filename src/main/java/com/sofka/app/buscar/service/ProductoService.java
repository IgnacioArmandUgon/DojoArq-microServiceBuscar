package com.sofka.app.buscar.service;

import com.sofka.app.buscar.model.Producto;
import com.sofka.app.buscar.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository repository;

    public Flux<Producto> listarTodos(){
        return this.repository.findAll();
    }
}
