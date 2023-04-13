package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDeSalarioTest {
    private Funcionario desenvolvedor;
    @BeforeEach
    void setUp() {
        this.desenvolvedor = new Funcionario("Deyde", "deyde.costa", 3000.0, Cargo.DESENVOLVEDOR);
    }


    @Test
    void deveRetornarZero(){

    }
}