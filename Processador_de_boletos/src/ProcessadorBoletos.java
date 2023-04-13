package Processador_de_boletos.src;

import java.util.List;

public class ProcessadorBoletos {

    public ProcessadorBoletos() {
    }

    public void processa(List<Boleto> boletos, Fatura fatura) {
        for(int i=0; i < boletos.size(); i++){
            fatura.addPagamento(boletos.get(i));
        }
    }


}
