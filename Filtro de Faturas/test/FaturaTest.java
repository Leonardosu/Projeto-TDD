import model.Cliente;
import model.Estado;
import model.Fatura;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.fail;

public class FaturaTest {

    Cliente cliente;
    Date data;
    Estado pb;

    @BeforeEach
    public void setup() {
        data = new Date();
        pb = new Estado("PB");
        cliente = new Cliente("fulano", data, pb);
    }

    @Test
    public void testValorNegativo() {
        try {
            Fatura fatura = new Fatura("333", -3, data, cliente);
            fail("Valor não pode ser negativo");
        } catch (Exception e) {
        }
    }

}
