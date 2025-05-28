package com.curso.domains.frete;

import java.math.BigDecimal;

public interface FreteStrategy {

    BigDecimal calcular(BigDecimal valor);
}
