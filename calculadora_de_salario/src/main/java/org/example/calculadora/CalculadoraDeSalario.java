package org.example.calculadora;

import org.example.calculadora.tiposCalculadoras.*;
import org.example.funcionario.Cargo;
import org.example.funcionario.Funcionario;

import java.util.Optional;

public class CalculadoraDeSalario {

    public Double calculaSalarioLiquido(Funcionario funcionario) throws Exception {

        Optional<Cargo> cargoOptional = Optional.ofNullable(funcionario.getCargo());
        TipoCalculadora tipoCalculadora = getTipoCalculadora(
                cargoOptional.orElseThrow(() ->
                        new IllegalArgumentException("O cargo do funcionário não pode ser nulo")));

        Optional<Double> salarioBaseOptional = Optional.ofNullable(funcionario.getSalarioBase());
        return tipoCalculadora.calculaSalarioLiquido(
                salarioBaseOptional.orElseThrow(() ->
                        new IllegalArgumentException("O salário base do funcionário não pode ser nulo"))
        );
    }

    public TipoCalculadora getTipoCalculadora(Cargo cargo) throws Exception {
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
        throw new Exception("Tipo de cargo desconhecido para a calculadora de salario");
    }

}
