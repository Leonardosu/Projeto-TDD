import java.util.Date;

public class Fatura {
    String codigo;
    double valor;
    Date date;
    Cliente cliente;
    public Fatura(String codigo, double valor, Date date, Cliente cliente) {
        this.codigo = codigo;
        this.valor = valor;
        this.date = date;
        this.cliente = cliente;
        if (valor < 0) {
            throw new IllegalArgumentException();
        }
    }
}
