package org.example.calculadora.tiposCalculadoras;

public class CalculaGerente implements TipoCalculadora {
    private final Double LIMITE = 5000.0;

    @Override
    public Double calculaSalarioLiquido(Double salarioBase) {
        Double desconto = salarioBase >= LIMITE ? 0.3 : 0.2;
        return salarioBase * (1.0 - desconto);
    }
}
