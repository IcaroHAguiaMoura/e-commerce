package com.curso.domains;

import com.curso.domains.state.EstadoPedido;

public class EstadoEnviado implements EstadoPedido {

    public void pagar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi enviado.");
    }
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido já foi enviado.");
    }
    public void cancelar(Pedido pedido) {
        throw new IllegalStateException("Pedido enviado não pode ser cancelado.");
    }
    public StatusPedido getStatus() {
        return StatusPedido.ENVIADO;
    }
}
