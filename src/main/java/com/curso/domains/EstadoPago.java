package com.curso.domains;

import com.curso.domains.state.EstadoPedido;

public class EstadoPago implements EstadoPedido {
    public void pagar(Pedido pedido){
        throw new IllegalStateException("Pedido ja foi pago");
    }
    public void enviar(Pedido pedido) {
        pedido.setEstado(new EstadoEnviado());
    }
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new EstadoCancelado());
    }
    public StatusPedido getStatus() {
        return StatusPedido.PAGO;
    }
}
