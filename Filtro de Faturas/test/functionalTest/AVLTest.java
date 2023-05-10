package functionalTest;

import model.Cliente;
import model.Estado;
import model.Fatura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AVLTest {
    Cliente client;
    @BeforeEach
    public void createCliente() {
        Date date = Date.from(ZonedDateTime.now().minusMonths(0).toInstant());
        Estado estado = new Estado("PB");

        cliente = new Cliente("Leonardo", date, estado)
    }
    @Test
    public void testeCriterio1() {
        List<Fatura> faturas = new ArrayList<>();
        Fatura fatura = new Fatura("333", 0.-1, null, null);
        faturas.add(fatura);

        assertEquals(faturas, Filtro.filtraFaturas(faturas));
    }

}
