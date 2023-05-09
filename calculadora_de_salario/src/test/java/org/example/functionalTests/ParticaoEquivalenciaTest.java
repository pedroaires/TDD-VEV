package org.example.functionalTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.example.calculadora.CalculadoraDeSalario;
import org.example.funcionario.Cargo;
import org.example.funcionario.Funcionario;

public class ParticaoEquivalenciaTest {
    
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
    public void ct01() throws Exception{
        try {
            this.desenvolvedor.setSalarioBase(-1.0);
            fail("Deveria ter lançado uma exceção de salário inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("Salário inválido", e.getMessage());
        }
        
    }
    @Test
    public void ct02() throws Exception{
        this.desenvolvedor.setSalarioBase(2000.0);
        assertEquals(1800.0, sobreTeste.calculaSalarioLiquido(desenvolvedor));
    }
    @Test
    public void ct03() throws Exception{
        this.desenvolvedor.setSalarioBase(3000.0);
        assertEquals(2400.0, sobreTeste.calculaSalarioLiquido(desenvolvedor));
    }

    @Test
    public void ct04() throws Exception{
        try {
            this.dba.setSalarioBase(-1.0);
            fail("Deveria ter lançado uma exceção de salário inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("Salário inválido", e.getMessage());
        }
    }
    @Test
    public void ct05() throws Exception{
        this.dba.setSalarioBase(1000.0);
        assertEquals(850.0, sobreTeste.calculaSalarioLiquido(dba));
    }
    @Test
    public void ct06() throws Exception{
        this.dba.setSalarioBase(2000.0);
        assertEquals(1500.0, sobreTeste.calculaSalarioLiquido(dba));
    }

    @Test
    public void ct07() throws Exception{
        try {
            this.testador.setSalarioBase(-1.0);
            fail("Deveria ter lançado uma exceção de salário inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("Salário inválido", e.getMessage());
        }
    }
    @Test
    public void ct08() throws Exception{
        this.testador.setSalarioBase(1000.0);
        assertEquals(850.0, sobreTeste.calculaSalarioLiquido(testador));
    }
    @Test
    public void ct09() throws Exception{
        this.testador.setSalarioBase(2000.0);
        assertEquals(1500.0, sobreTeste.calculaSalarioLiquido(testador));
    }

    @Test
    public void ct10() throws Exception{
        try {
            this.gerente.setSalarioBase(-1.0);
            fail("Deveria ter lançado uma exceção de salário inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("Salário inválido", e.getMessage());
        }
    }
    @Test
    public void ct11() throws Exception{
        this.gerente.setSalarioBase(3000.0);
        assertEquals(2400.0, sobreTeste.calculaSalarioLiquido(gerente));
    }
    @Test
    public void ct12() throws Exception{
        this.gerente.setSalarioBase(5000.0);
        assertEquals(3500.0, sobreTeste.calculaSalarioLiquido(gerente));
    }
}
