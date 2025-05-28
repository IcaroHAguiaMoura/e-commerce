package com.curso.domains;

import com.curso.domains.frete.FreteStrategy;
import com.curso.domains.frete.FreteAereo;
import com.curso.domains.frete.FreteTerrestre;
import com.curso.domains.state.EstadoAguardandoPagamento;
import com.curso.domains.state.EstadoPedido;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private BigDecimal valorFrete;

    private String tipoFrete; // Agora persistido no banco

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Transient
    private FreteStrategy freteStrategy;

    @Transient
    private EstadoPedido estado;

    public Pedido() {
    }

    public Pedido(BigDecimal valor, FreteStrategy freteStrategy) {
        this.valor = valor;
        this.freteStrategy = freteStrategy;
        this.tipoFrete = freteStrategy.getClass().getSimpleName().replace("Frete", "").toUpperCase();
        this.estado = new EstadoAguardandoPagamento();
        this.status = estado.getStatus();
        this.valorFrete = freteStrategy.calcular(valor);
    }

    public void pagar() {
        estado.pagar(this);
        this.status = estado.getStatus();
    }

    public void enviar() {
        estado.enviar(this);
        this.status = estado.getStatus();
    }

    public void cancelar() {
        estado.cancelar(this);
        this.status = estado.getStatus();
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    // GETTERS E SETTERS

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

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public FreteStrategy getFreteStrategy() {
        return freteStrategy;
    }

    public void setFreteStrategy(FreteStrategy freteStrategy) {
        this.freteStrategy = freteStrategy;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public String getTipoFrete() {
        return tipoFrete;
    }

    public void setTipoFrete(String tipoFrete) {
        this.tipoFrete = tipoFrete;
    }
}
