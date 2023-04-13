package Processador_de_boletos.test;

import org.junit.Test;

import Processador_de_boletos.src.Boleto;
import Processador_de_boletos.src.Fatura;
import Processador_de_boletos.src.Pagamento;

import static org.junit.Assert.*;

public class ProcessadorBoletosTest{

    @Test
    public void testEmptyFatura(){
        Fatura fatura = new Fatura();
        assertNull(fatura.getData());
        assertNull(fatura.getNomeCliente());
        assertTrue(0F == fatura.getValorTotal());
    }

    @Test
    public void testEmptyPagamento(){
        Pagamento pagamento = new Pagamento();
        assertTrue(0F == pagamento.getValorPago());
        assertNull(pagamento.getData());
        assertNull(pagamento.getTipoPagamento());
    }

    @Test
    public void testEmptyBoleto(){
        Boleto boleto = new Boleto();
        assertTrue(0F == boleto.getValorPago());
        assertNull(boleto.getData());
    }
    


}

