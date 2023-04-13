package org.example;

public class CalculadoraDeSalario {


    public Double calculaSalarioLiquido(Funcionario funcionario){
        Double desconto = 0.1;

        return funcionario.getSalarioBase() * (1.0 - desconto);
    }
}
