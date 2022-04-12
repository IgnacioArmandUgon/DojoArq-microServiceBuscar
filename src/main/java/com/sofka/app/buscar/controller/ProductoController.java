package com.sofka.app.buscar.controller;

import com.sofka.app.buscar.Dto.ProductoDto;
import com.sofka.app.buscar.model.Producto;
import com.sofka.app.buscar.service.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    ProductoService service;
    ModelMapper mapper;

    public ProductoController (ModelMapper mapper){
        this.mapper = mapper;
    }

    @GetMapping("/productos")
    public Flux<ProductoDto> findAll(){
        return this.service.listarTodos()
                .flatMap(p -> Mono.just(mapper.map(p, ProductoDto.class)));
    }
}
