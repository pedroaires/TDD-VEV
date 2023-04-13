package Processador_de_boletos.src;

public class Pagamento {

    private Float valorPago;
    private String data;
    private String tipoPagamento;


    public Pagamento() {
        this.valorPago = 0F;
        this.data = null;
        this.tipoPagamento = null;
    }

    public Pagamento(Float valorPago, String data, String tipoPagamento) {
        this.valorPago = valorPago;
        this.data = data;
        this.tipoPagamento = tipoPagamento;
    }

    public Float getValorPago() {
        return valorPago;
    }

    public String getData() {
        return data;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }


    
}
