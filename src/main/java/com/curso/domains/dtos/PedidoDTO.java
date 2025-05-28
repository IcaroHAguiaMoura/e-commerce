package com.curso.domains.dtos;

import com.curso.domains.Pedido;

import java.math.BigDecimal;

public class PedidoDTO {

    private Long id;
    private BigDecimal valor;
    private BigDecimal valorFrete;
    private String tipoFrete;
    private String status;

    public PedidoDTO() {}

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.valor = pedido.getValor();
        this.valorFrete = pedido.getValorFrete();
        this.status = pedido.getStatus().name();
        this.tipoFrete = pedido.getTipoFrete();

    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getTipoFrete() {
        return tipoFrete;
    }

    public void setTipoFrete(String tipoFrete) {
        this.tipoFrete = tipoFrete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
