package org.example.calculadora.tiposCalculadoras;

public class CalculaDesenvolvedor implements TipoCalculadora {
    private final Double LIMITE = 3000.0;

    @Override
    public Double calculaSalarioLiquido(Double salarioBase) {
        Double desconto = salarioBase >= LIMITE ? 0.2 : 0.1;
        return salarioBase * (1.0 - desconto);
    }
}

