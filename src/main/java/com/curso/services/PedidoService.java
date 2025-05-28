package com.curso.services;

import com.curso.domains.Pedido;
import com.curso.domains.frete.FreteAereo;
import com.curso.domains.frete.FreteStrategy;
import com.curso.domains.frete.FreteTerrestre;
import com.curso.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public List<Pedido> ListarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(BigDecimal valor, String tipoFrete) {
        FreteStrategy freteStrategy = switch (tipoFrete.toUpperCase()) {
            case "AEREO" -> new FreteAereo();
            case "TERRESTRE" -> new FreteTerrestre();
            default -> throw new IllegalArgumentException("Tipo de frente invalido");
        };

        Pedido pedido = new Pedido(valor, freteStrategy);
        return pedidoRepository.save(pedido);
    }

    public Pedido pagarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedido.setEstado(pedido.getStatus().getEstado());
        pedido.pagar();
        return pedidoRepository.save(pedido);
    }
        public Pedido enviarPedido (Long id){
            Pedido pedido = pedidoRepository.findById(id).orElseThrow();
            pedido.setEstado(pedido.getStatus().getEstado());  // Ajuste necessário
            pedido.enviar();
            return pedidoRepository.save(pedido);
        }
        public Pedido cancelarPedido (Long id){
            Pedido pedido = pedidoRepository.findById(id).orElseThrow();
            pedido.setEstado(pedido.getStatus().getEstado());  // Ajuste necessário
            pedido.cancelar();
            return pedidoRepository.save(pedido);
        }

    }


