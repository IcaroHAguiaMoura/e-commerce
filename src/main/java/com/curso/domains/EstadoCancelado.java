package com.curso.domains;

import com.curso.domains.state.EstadoPedido;

public class EstadoCancelado implements EstadoPedido {
    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido foi cancelado.");
    }
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido foi cancelado.");
    }
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi cancelado.");
    }
    public StatusPedido getStatus() {
        return StatusPedido.CANCELADO;
    }
}
