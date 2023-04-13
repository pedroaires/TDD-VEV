package org.example.calculadora;

import org.example.calculadora.tiposCalculadoras.*;
import org.example.funcionario.Cargo;
import org.example.funcionario.Funcionario;

import java.util.Optional;

public class CalculadoraDeSalario {

    public Double calculaSalarioLiquido(Funcionario funcionario){

        Optional<Cargo> cargoOptional = Optional.ofNullable(funcionario.getCargo());
        TipoCalculadora tipoCalculadora = getTipoCalculadora(
                cargoOptional.orElseThrow(() ->
                        new IllegalArgumentException("O cargo do funcionário não pode ser nulo")));
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
