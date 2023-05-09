package Processador_de_boletos.test;

import Processador_de_boletos.src.Boleto;
import Processador_de_boletos.src.Fatura;
import Processador_de_boletos.src.Pagamento;
import Processador_de_boletos.src.ProcessadorBoletos;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
        assertNull(pagamento.getTipo());
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

        List<Boleto> boletos = Arrays.asList(
            new Boleto(1, "01/01/2023", 500.00F),
            new Boleto(2, "01/01/2023", 400.00F),
            new Boleto(3, "01/01/2023", 600.00F)
        );
        Fatura fatura = new Fatura("João", "01/01/2023", 1000.00F);

        processador.processa(boletos, fatura);

        assertEquals(3, fatura.getPagamentos().size());
    }
    
    @Test
    public void criaPagamentoTest(){
        ProcessadorBoletos processador = new ProcessadorBoletos();

        Boleto boleto = new Boleto(1, "01/01/2023", 500.00F);
        Fatura fatura = new Fatura("João", "01/01/2023", 1000.00F);

        processador.processa(Arrays.asList(boleto), fatura);

        Pagamento pagamento = fatura.getPagamentos().get(0);
        assertEquals("BOLETO", pagamento.getTipo());
        assertTrue(500.00F == pagamento.getValorPago());
        assertEquals("01/01/2023", pagamento.getData());
    }  

    @Test
    public void somaPagamentosTest() {
        ProcessadorBoletos processador = new ProcessadorBoletos();
        List<Boleto> boletos = Arrays.asList(
            new Boleto(1, "01/01/2023", 500.00F),
            new Boleto(2, "01/01/2023", 400.00F),
            new Boleto(3, "01/01/2023", 600.00F)
        );
        Fatura fatura = new Fatura("João", "01/01/2023", 1000.00F);
        processador.processa(boletos, fatura);

        assertTrue(1500.00F == fatura.getValorTotalPagamentos());
    }

    @Test
    public void marcaFaturaPagaTest() {
        ProcessadorBoletos pb = new ProcessadorBoletos();
        List<Boleto> boletos = Arrays.asList(
            new Boleto(1, "01/01/2023", 500.00F),
            new Boleto(2, "01/01/2023", 400.00F),
            new Boleto(3, "01/01/2023", 600.00F)
        );

        Fatura fatura = new Fatura("João", "01/01/2023", 1500.00F);
        pb.processa(boletos, fatura);
        assertTrue(fatura.isPago());
    }


}

