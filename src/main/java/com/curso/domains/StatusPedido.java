package com.curso.domains;

import com.curso.domains.state.EstadoAguardandoPagamento;
import com.curso.domains.state.EstadoPedido;

public enum StatusPedido {
    AGUARDANDO_PAGAMENTO {
        @Override
        public EstadoPedido getEstado() {
            return new EstadoAguardandoPagamento();
        }
    },
    PAGO {
        @Override
        public EstadoPedido getEstado() {
            return new EstadoPago();
        }
    },
    ENVIADO {
        @Override
        public EstadoPedido getEstado() {
            return new EstadoEnviado();
        }
    },
    CANCELADO {
        @Override
        public EstadoPedido getEstado() {
            return new EstadoCancelado();
        }
    };

    public abstract EstadoPedido getEstado();
}
