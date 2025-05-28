package com.curso.domains.state;

import com.curso.domains.Pedido;
import com.curso.domains.StatusPedido;

public interface EstadoPedido {

    void pagar(Pedido pedido);
    void enviar(Pedido pedido);
    void cancelar(Pedido pedido);
    StatusPedido getStatus();
}
