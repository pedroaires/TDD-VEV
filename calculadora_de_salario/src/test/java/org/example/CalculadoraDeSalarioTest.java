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

        this.desenvolvedor = new Funcionario("joao", "joao.pe.de.feijao", 3000.0, Cargo.DESENVOLVEDOR);
        this.dba = new Funcionario("renato", "renato.ingrato", 3000.0, Cargo.DBA);
        this.gerente = new Funcionario("marco", "marco.polo", 3000.0, Cargo.GERENTE);
        this.testador = new Funcionario("hello", "hello.kitty", 3000.0, Cargo.TESTADOR);
    }


    @Test
    void deveRetornarZero(){
        this.desenvolvedor.setSalarioBase(0.0);
        this.dba.setSalarioBase(0.0);
        this.gerente.setSalarioBase(0.0);
        this.testador.setSalarioBase(0.0);

        assertEquals(0.0, sobreTeste.calculaSalarioLiquido(desenvolvedor));
    }

    @Test
    void deveRetornarCorretoLimiteInferiorDesenvolvedor(){
        Double limiteInferior = 2999.99;
        this.desenvolvedor.setSalarioBase(limiteInferior);

        Double desconto = 0.1;
        Double expected = limiteInferior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(desenvolvedor));
    }

    @Test
    void deveRetornarCorretoLimiteInferiorDba(){
        Double limiteInferior = 1999.99;
        this.dba.setSalarioBase(limiteInferior);

        Double desconto = 0.15;
        Double expected = limiteInferior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(dba));
    }

    @Test
    void deveRetornarCorretoLimiteInferiorGerente(){
        Double limiteInferior = 4999.99;
        this.gerente.setSalarioBase(limiteInferior);

        Double desconto = 0.2;
        Double expected = limiteInferior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(gerente));
    }

    @Test
    void deveRetornarCorretoLimiteInferiorTestador(){
        Double limiteInferior = 1999.99;
        this.testador.setSalarioBase(limiteInferior);

        Double desconto = 0.15;
        Double expected = limiteInferior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(testador));
    }
}