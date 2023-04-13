package Processador_de_boletos.test;

import org.junit.Test;

import Processador_de_boletos.src.Boleto;
import Processador_de_boletos.src.Fatura;
import Processador_de_boletos.src.Pagamento;
import Processador_de_boletos.src.ProcessadorBoletos;

import static org.junit.Assert.*;

import java.util.Arrays;

public class ProcessadorBoletosTest{

    @Test
    public void emptyFaturaTest(){
        Fatura fatura = new Fatura();
        assertNull(fatura.getData());
        assertNull(fatura.getNomeCliente());
        assertTrue(0F == fatura.getValorTotal());
    }

    @Test
    public void criaFaturaTest(){
        Fatura fatura = new Fatura("João", "01/01/2023", 1000.00F);
        assertTrue(1000.00F == fatura.getValorTotal());
        assertTrue("João" == fatura.getNomeCliente());
        assertTrue("01/01/2023" == fatura.getData());
    }

    @Test
    public void emptyPagamentoTest(){
        Pagamento pagamento = new Pagamento();
        assertTrue(0F == pagamento.getValorPago());
        assertNull(pagamento.getData());
        assertNull(pagamento.getTipoPagamento());
    }

    @Test
    public void emptyBoletoTest(){
        Boleto boleto = new Boleto();
        assertTrue(0F == boleto.getValorPago());
        assertNull(boleto.getData());
    }

    @Test
    public void criaBoletoTest(){
        Boleto boleto = new Boleto(1, "01/01/2023", 500.00F);
        assertTrue(500.00F == boleto.getValorPago());
        assertTrue("01/01/2023" == boleto.getData());
        assertTrue(1 == boleto.getCodigo());
    }

    @Test
    public void criaProcessadorBoletosTest(){
        ProcessadorBoletos processador = new ProcessadorBoletos();

        Boleto boleto = new Boleto(1, "01/01/2023", 500.00F);
        Fatura fatura = new Fatura("João", "01/01/2023", 1000.00F);

        processador.processa(Arrays.asList(boleto), fatura);

        assertEquals(1, fatura.getPagamentos().size());
    }
    
       


}

