import Processador_de_boletos.src.Boleto;
import Processador_de_boletos.src.Fatura;
import Processador_de_boletos.src.ProcessadorBoletos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AvlTest {

    private ProcessadorBoletos processador;
    private List<Boleto> boletos;
    private Fatura fatura;

    @BeforeEach
    public void setUp() {
        this.processador = new ProcessadorBoletos();
        this.boletos = new ArrayList<>();
    }

    @Test
    public void deveMarcarNaoPagaValorNulo(){
        Boleto boleto = new Boleto(1, "01/01/2023", 0F);
        this.fatura = new Fatura("João", "01/01/2023", 20.00F);
        boletos.add(boleto);
        processador.processa(boletos, fatura);
        assertFalse(fatura.isPago());
    }

    @Test
    public void deveMarcarPagaValorNulo(){
        Boleto boleto = new Boleto(1, "01/01/2023", 0F);
        this.fatura = new Fatura("João", "01/01/2023", 0F);
        boletos.add(boleto);
        processador.processa(boletos, fatura);
        assertTrue(fatura.isPago());
    }

    @Test
    public void deveMarcarNaoPagaValorQualquerMenorQueFatura(){
        Boleto boleto = new Boleto(1, "01/01/2023", 10F);
        this.fatura = new Fatura("João", "01/01/2023", 20F);
        boletos.add(boleto);
        processador.processa(boletos, fatura);
        assertFalse(fatura.isPago());
    }

    @Test
    public void deveMarcarNaoPagaValorLimiteMenorQueFatura(){
        Boleto boleto = new Boleto(1, "01/01/2023", 19.99F);
        this.fatura = new Fatura("João", "01/01/2023", 20F);
        boletos.add(boleto);
        processador.processa(boletos, fatura);
        assertFalse(fatura.isPago());
    }

    @Test
    public void deveMarcarPagaValorLimiteFatura(){
        Boleto boleto = new Boleto(1, "01/01/2023", 20F);
        this.fatura = new Fatura("João", "01/01/2023", 20F);
        boletos.add(boleto);
        processador.processa(boletos, fatura);
        assertTrue(fatura.isPago());
    }

    @Test
    public void deveMarcarPagaValorQualquerMaiorQueFatura(){
        Boleto boleto = new Boleto(1, "01/01/2023", 30F);
        this.fatura = new Fatura("João", "01/01/2023", 20F);
        boletos.add(boleto);
        processador.processa(boletos, fatura);
        assertTrue(fatura.isPago());
    }

    @Test
    public void deveLancarExcecaoFaturaNegativaLimite(){
        Boleto boleto = new Boleto(1, "01/01/2023", 30F);
        this.fatura = new Fatura("João", "01/01/2023", -0.01F);
        boletos.add(boleto);

        assertThrows(Exception.class, () -> processador.processa(boletos, fatura));
    }

    @Test
    public void deveLancarExcecaoFaturaNegativaQualquer(){
        Boleto boleto = new Boleto(1, "01/01/2023", 30F);
        this.fatura = new Fatura("João", "01/01/2023", 10F);
        boletos.add(boleto);

        assertThrows(Exception.class, () -> processador.processa(boletos, fatura));
    }

    @Test
    public void deveLancarExcecaoBoletoNegativoLimite(){
        Boleto boleto = new Boleto(1, "01/01/2023", -10F);
        this.fatura = new Fatura("João", "01/01/2023", 10F);
        boletos.add(boleto);

        assertThrows(Exception.class, () -> processador.processa(boletos, fatura));
    }

    @Test
    public void deveLancarExcecaoBoletoNegativoQualquer(){
        Boleto boleto = new Boleto(1, "01/01/2023", -0.01F);
        this.fatura = new Fatura("João", "01/01/2023", 10F);
        boletos.add(boleto);

        assertThrows(Exception.class, () -> processador.processa(boletos, fatura));
    }

}