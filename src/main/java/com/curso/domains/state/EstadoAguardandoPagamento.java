package com.curso.domains.state;

import com.curso.domains.EstadoCancelado;
import com.curso.domains.EstadoPago;
import com.curso.domains.Pedido;
import com.curso.domains.StatusPedido;

public class EstadoAguardandoPagamento implements EstadoPedido {
    public void pagar(Pedido pedido){
        pedido.setEstado(new EstadoPago());
    }
    public void enviar(Pedido pedido) {
        throw new IllegalStateException("Pedido não pode ser enviado antes do pagamento.");
    }
    public void cancelar(Pedido pedido) {
        pedido.setEstado(new EstadoCancelado());
    }
    public StatusPedido getStatus() {
        return StatusPedido.AGUARDANDO_PAGAMENTO;
    }
}
