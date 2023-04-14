package org.example.calculadora;

import org.example.funcionario.Cargo;
import org.example.funcionario.Funcionario;
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
    void deveRetornarZero() throws Exception {
        this.desenvolvedor.setSalarioBase(0.0);
        this.dba.setSalarioBase(0.0);
        this.gerente.setSalarioBase(0.0);
        this.testador.setSalarioBase(0.0);

        assertEquals(0.0, sobreTeste.calculaSalarioLiquido(desenvolvedor));
        assertEquals(0.0, sobreTeste.calculaSalarioLiquido(dba));
        assertEquals(0.0, sobreTeste.calculaSalarioLiquido(gerente));
        assertEquals(0.0, sobreTeste.calculaSalarioLiquido(testador));
    }

    @Test
    void deveRetornarCorretoLimiteInferiorDesenvolvedor() throws Exception {
        Double limiteInferior = 2999.99;
        this.desenvolvedor.setSalarioBase(limiteInferior);

        Double desconto = 0.1;
        Double expected = limiteInferior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(desenvolvedor));
    }

    @Test
    void deveRetornarCorretoLimiteInferiorDba() throws Exception {
        Double limiteInferior = 1999.99;
        this.dba.setSalarioBase(limiteInferior);

        Double desconto = 0.15;
        Double expected = limiteInferior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(dba));
    }

    @Test
    void deveRetornarCorretoLimiteInferiorGerente() throws Exception{
        Double limiteInferior = 4999.99;
        this.gerente.setSalarioBase(limiteInferior);

        Double desconto = 0.2;
        Double expected = limiteInferior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(gerente));
    }

    @Test
    void deveRetornarCorretoLimiteInferiorTestador() throws Exception{
        Double limiteInferior = 1999.99;
        this.testador.setSalarioBase(limiteInferior);

        Double desconto = 0.15;
        Double expected = limiteInferior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(testador));
    }

    @Test
    void deveRetornarCorretoLimiteSuperiorDesenvolvedor() throws Exception{
        Double limiteSuperior = 3000.0;
        this.desenvolvedor.setSalarioBase(limiteSuperior);

        Double desconto = 0.2;
        Double expected = limiteSuperior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(desenvolvedor));
    }

    @Test
    void deveRetornarCorretoLimiteSuperiorDba() throws Exception{
        Double limiteSuperior = 2000.0;
        this.dba.setSalarioBase(limiteSuperior);

        Double desconto = 0.25;
        Double expected = limiteSuperior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(dba));
    }

    @Test
    void deveRetornarCorretoLimiteSuperiorGerente() throws Exception{
        Double limiteSuperior = 5000.0;
        this.gerente.setSalarioBase(limiteSuperior);

        Double desconto = 0.3;
        Double expected = limiteSuperior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(gerente));
    }

    @Test
    void deveRetornarCorretoLimiteSuperiorTestador() throws Exception{
        Double limiteSuperior = 2000.0;
        this.testador.setSalarioBase(limiteSuperior);

        Double desconto = 0.25;
        Double expected = limiteSuperior * (1.0 - desconto);

        assertEquals(expected, sobreTeste.calculaSalarioLiquido(testador));
    }

    @Test
    void deveLancarExcecaoCargoNulo() throws Exception{
        this.desenvolvedor.setCargo(null);
        this.dba.setCargo(null);
        this.testador.setCargo(null);
        this.gerente.setCargo(null);

        String expectedExceptionMessage = "O cargo do funcionário não pode ser nulo";
        assertThrows(IllegalArgumentException.class, () -> sobreTeste.calculaSalarioLiquido(desenvolvedor))
                .getMessage().equals(expectedExceptionMessage);
        assertThrows(IllegalArgumentException.class, () -> sobreTeste.calculaSalarioLiquido(dba))
                .getMessage().equals(expectedExceptionMessage);
        assertThrows(IllegalArgumentException.class, () -> sobreTeste.calculaSalarioLiquido(gerente))
                .getMessage().equals(expectedExceptionMessage);
        assertThrows(IllegalArgumentException.class, () -> sobreTeste.calculaSalarioLiquido(testador))
                .getMessage().equals(expectedExceptionMessage);
    }

    @Test
    void deveLancarExcecaoSalarioNulo() throws Exception{
        this.desenvolvedor.setSalarioBase(null);
        this.dba.setSalarioBase(null);
        this.testador.setSalarioBase(null);
        this.gerente.setSalarioBase(null);

        String expectedExceptionMessage = "O salário base do funcionário não pode ser nulo";
        assertThrows(IllegalArgumentException.class, () -> sobreTeste.calculaSalarioLiquido(desenvolvedor))
                .getMessage().equals(expectedExceptionMessage);
        assertThrows(IllegalArgumentException.class, () -> sobreTeste.calculaSalarioLiquido(dba))
                .getMessage().equals(expectedExceptionMessage);
        assertThrows(IllegalArgumentException.class, () -> sobreTeste.calculaSalarioLiquido(gerente))
                .getMessage().equals(expectedExceptionMessage);
        assertThrows(IllegalArgumentException.class, () -> sobreTeste.calculaSalarioLiquido(testador))
                .getMessage().equals(expectedExceptionMessage);
    }

}