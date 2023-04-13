package Processador_de_boletos.src;

import java.util.ArrayList;
import java.util.List;

public class Fatura {

    private String data; 
    private String nomeCliente;
    private Float valorTotal;
    private List<Pagamento> pagamentos;

    public Fatura() {
        this.data = null;
        this.nomeCliente = null;
        this.valorTotal = 0F;
    }

    public Fatura(String nomeCliente, String data, Float valorTotal) {
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.valorTotal = valorTotal;
        this.pagamentos = new ArrayList<Pagamento>();
    }

    public String getData() {
        return data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public List<Pagamento> getPagamentos() {
        return this.pagamentos;
    }

    public void addPagamento(Boleto boleto) {
        Pagamento pagamento = new Pagamento(boleto.getValorPago(), boleto.getData(), "BOLETO");
        pagamentos.add(pagamento);
    }

    public boolean isPago(){
        float valorPagado = 0;
        for(int i=0; i<=this.pagamentos.size();i++){
            valorPagado += pagamentos.get(i).getValorPago();
        }

        return this.valorTotal <= valorPagado;
    }

    

    

}
