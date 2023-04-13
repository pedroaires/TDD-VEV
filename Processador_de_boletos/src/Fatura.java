package Processador_de_boletos.src;


public class Fatura {

    private String data; 
    private String nomeCliente;
    private Float valorTotal;

    public Fatura() {
        this.data = null;
        this.nomeCliente = null;
        this.valorTotal = 0F;
    }

    public Fatura(String nomeCliente, String data, Float valorTotal) {
        this.data = data;
        this.nomeCliente = nomeCliente;
        this.valorTotal = valorTotal;
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

    

    

}
