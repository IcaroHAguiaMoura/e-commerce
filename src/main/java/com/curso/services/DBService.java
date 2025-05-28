package com.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.math.BigDecimal;

@Service
public class DBService {

    @Autowired
    private PedidoService pedidoService;

    @PostConstruct
    public void initDB() {
        pedidoService.criarPedido(BigDecimal.valueOf(293.0), "TERRESTRE");
        pedidoService.criarPedido(BigDecimal.valueOf(500.0), "AEREO");


    }
}
