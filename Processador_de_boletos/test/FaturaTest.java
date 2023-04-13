package Processador_de_boletos.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class FaturaTest{

    @Test
    void testEmptyFatura(){
        Fatura fatura = new Fatura();
        assertEquals(0, fatura.getValorTotal());
        assertEquals(0, fatura.getBoletos().size());
        assertNull(fatura.getData());
        assertNull(fatura.getNome());
    }


    @Test
    void testEmptyPagamento(){
        Pagamento pagamento = new Pagamento();
        assertEquals(0, pagamento.getValorPago());
        assertNull(pagamento.getData());
        assertNull(pagamento.getTipoPagamento());
    }

}

