package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeSalarioTest {
    private Funcionario desenvolvedor;
    private Funcionario dba;
    private Funcionario gerente;
    private Funcionario testador;

    private CalculadoraDeSalario sobreTeste;
    @BeforeEach
    void setUp() {
        this.sobreTeste = new CalculadoraDeSalario();

        this.desenvolvedor = new Funcionario("Deyde", "deyde.costa", 3000.0, Cargo.DESENVOLVEDOR);
        this.dba = new Funcionario("Deyde", "deyde.costa", 3000.0, Cargo.DBA);
        this.gerente = new Funcionario("Deyde", "deyde.costa", 3000.0, Cargo.GERENTE);
        this.testador = new Funcionario("Deyde", "deyde.costa", 3000.0, Cargo.TESTADOR);
    }


    @Test
    void deveRetornarZero(){
        this.desenvolvedor.setSalarioBase(0.0);
        this.dba.setSalarioBase(0.0);
        this.gerente.setSalarioBase(0.0);
        this.testador.setSalarioBase(0.0);

        assertEquals(0.0, sobreTeste.calculaSalarioLiquido(desenvolvedor));
    }
}