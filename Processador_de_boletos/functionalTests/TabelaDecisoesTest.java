import Processador_de_boletos.src.Boleto;
import Processador_de_boletos.src.Fatura;
import Processador_de_boletos.src.ProcessadorBoletos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TabelaDecisoesTest {
    private ProcessadorBoletos processador;
    private List<Boleto> boletos;
    private Fatura fatura;

    @BeforeEach
    public void setUp() {
        this.processador = new ProcessadorBoletos();
        this.boletos = new ArrayList<>();
    }

    @Test
    public void deveLancarExcecaoPagamentoNegativo(){
        Boleto boleto = new Boleto(1, "01/01/2023", -1F);
        this.fatura = new Fatura("João", "01/01/2023", 20F);
        boletos.add(boleto);
        assertThrows(Exception.class, () -> {
            processador.processa(boletos, fatura);
        });
    }

    @Test
    public void deveLancarExcecaoFaturaNegativa(){
        Boleto boleto = new Boleto(1, "01/01/2023", 1F);
        this.fatura = new Fatura("João", "01/01/2023", -1F);
        boletos.add(boleto);
        assertThrows(Exception.class, () -> {
            processador.processa(boletos, fatura);
        });
    }

    @Test
    public void deveMarcarPagaValorMaiorQueFatura(){
        Boleto boleto = new Boleto(1, "01/01/2023", 2F);
        Fatura fatura = new Fatura("João", "01/01/2023", 1F);
        boletos.add(boleto);
        processador.processa(boletos, fatura);
        assertTrue(fatura.isPago());
    }

    @Test
    public void deveMarcarNaoPagaValorMenorQueFatura(){
        Boleto boleto = new Boleto(1, "01/01/2023", 1F);
        Fatura fatura = new Fatura("João", "01/01/2023", 20F);
        boletos.add(boleto);
        processador.processa(boletos, fatura);
        assertFalse(fatura.isPago());
    }
}
