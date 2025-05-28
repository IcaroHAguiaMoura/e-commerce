package com.curso.domains.frete;

import java.math.BigDecimal;

public class FreteTerrestre implements FreteStrategy{

    public BigDecimal calcular(BigDecimal valor){
        return valor.multiply(BigDecimal.valueOf(0.05));
    }
}
