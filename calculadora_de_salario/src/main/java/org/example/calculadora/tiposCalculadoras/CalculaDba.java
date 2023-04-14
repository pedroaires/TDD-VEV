package org.example.calculadora.tiposCalculadoras;

public class CalculaDba implements TipoCalculadora {
    private final Double LIMITE = 2000.0;

    @Override
    public Double calculaSalarioLiquido(Double salarioBase) {
        Double desconto = salarioBase >= LIMITE ? 0.25 : 0.15;
        return salarioBase * (1.0 - desconto);
    }
}

