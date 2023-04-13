package org.example;

public class CalculadoraDeSalario {


    public Double calculaSalarioLiquido(Funcionario funcionario){
        Double desconto = 0.0;

        switch (funcionario.getCargo()){
            case DESENVOLVEDOR:
                desconto = 0.1;
                break;
            case DBA:
                desconto = 0.15;
                break;
            case TESTADOR:
                desconto = 0.15;
                break;
            case GERENTE:
                desconto = 0.2;
                break;
        }

        return funcionario.getSalarioBase() * (1.0 - desconto);
    }
}
