package org.example;



public class CalculadoraDeSalario {

    private final Double LIMITE_DESENVOLVEDOR = 3000.0;
    private final Double LIMITE_DBA_E_TESTADOR = 2000.0;
    private final Double LIMITE_GERENTE = 5000.0;


    public Double calculaSalarioLiquido(Funcionario funcionario){
        Double desconto = 0.0;

        switch (funcionario.getCargo()){
            case DESENVOLVEDOR:
                desconto = funcionario.getSalarioBase() >= LIMITE_DESENVOLVEDOR ? 0.2 : 0.1;
                break;
            case DBA:
                desconto = funcionario.getSalarioBase() >= LIMITE_DBA_E_TESTADOR ? 0.25 : 0.15;
                break;
            case TESTADOR:
                desconto = funcionario.getSalarioBase() >= LIMITE_DBA_E_TESTADOR ? 0.25 : 0.15;
                break;
            case GERENTE:
                desconto = funcionario.getSalarioBase() >= LIMITE_GERENTE ? 0.3 : 0.2;
                break;
        }

        return funcionario.getSalarioBase() * (1.0 - desconto);
    }

}
