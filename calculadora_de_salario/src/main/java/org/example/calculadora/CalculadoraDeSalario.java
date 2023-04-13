package org.example.calculadora;

import org.example.calculadora.tiposCalculadoras.*;
import org.example.funcionario.Cargo;
import org.example.funcionario.Funcionario;

public class CalculadoraDeSalario {

    private final Double LIMITE_DESENVOLVEDOR = 3000.0;
    private final Double LIMITE_DBA_E_TESTADOR = 2000.0;
    private final Double LIMITE_GERENTE = 5000.0;


    public Double calculaSalarioLiquido(Funcionario funcionario){
        TipoCalculadora tipoCalculadora = getTipoCalculadora(funcionario.getCargo());
        return tipoCalculadora.calculaSalarioLiquido(funcionario.getSalarioBase());
    }

    public TipoCalculadora getTipoCalculadora(Cargo cargo){
        switch(cargo){
            case DESENVOLVEDOR:
                return new CalculaDesenvolvedor();
            case DBA:
                return new CalculaDba();
            case TESTADOR:
                return new CalculaTestador();
            case GERENTE:
                return new CalculaGerente();
        }
        throw new RuntimeException("Cargo não gerenciado pela calculadora");
    }

}
