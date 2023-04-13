package Processador_de_boletos.src;


public class Boleto {

    private int codigo;
    private String data;
    private Float valorPago;

    public Boleto() {
        this.data = null;
        this.valorPago = 0F;
    }
    
    public Boleto(int codigo, String data, Float valorPago) {
        this.codigo = codigo;
        this.data = data;
        this.valorPago = valorPago;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public Float getValorPago() {
        return valorPago;
    }


    
}
