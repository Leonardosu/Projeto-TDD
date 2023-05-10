package functionalTest;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TDTest {
    private Cliente cliente;


    public Date geraDataAntigaCom(int meses) {
        return Date.from(ZonedDateTime.now().minusMonths(meses).minusMinutes(5).toInstant());
    }

    public Cliente geraCliente(String nome, String sigla, Date date) {
        Estado estado = new Estado(sigla);
        return new Cliente(nome, date, estado);
    }

    @BeforeEach
    public void inicializaCliente() {
        Date data = Date.from(ZonedDateTime.now().toInstant());
        cliente = geraCliente("Leonardo", "PB", data);
    }

    @Test
    public void testRegra1() {
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(new Fatura("335", 1000, geraDataAntigaCom(1), cliente));

        assertEquals(0, Filtro.filtraFaturas(faturas).size());
    }

    @Test
    public void testRegra2() {
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(new Fatura("335", 2200, geraDataAntigaCom(1), cliente));

        assertEquals(0, Filtro.filtraFaturas(faturas).size());
    }
    @Test
    public void testRegra3() {
        Date doisMeses = Date.from(ZonedDateTime.now().minusMonths(2).minusMinutes(5).toInstant());
        cliente = geraCliente("Leonardo", "PB", doisMeses);

        List<Fatura> faturas = new ArrayList<>();
        faturas.add(new Fatura("335", 2800, geraDataAntigaCom(2), cliente));

        assertEquals(0, Filtro.filtraFaturas(faturas).size());
    }
    @Test
    public void testRegra4() {
        Date doisMeses = Date.from(ZonedDateTime.now().minusMonths(2).toInstant());
        cliente = geraCliente("Leonardo", "SC", doisMeses);

        List<Fatura> faturas = new ArrayList<>();
        faturas.add(new Fatura("335", 5000, geraDataAntigaCom(1), cliente));

        assertEquals(0, Filtro.filtraFaturas(faturas).size());
    }

    @Test
    public void testNaoRemove() {
        Date umMeses = Date.from(ZonedDateTime.now().minusMonths(2).toInstant());
        cliente = geraCliente("Leonardo", "CE", umMeses);

        List<Fatura> faturas = new ArrayList<>();
        faturas.add(new Fatura("335", 5000, geraDataAntigaCom(2), cliente));

        assertEquals(1, Filtro.filtraFaturas(faturas).size());
    }
}
