package functionalTest;

import model.Cliente;
import model.Estado;
import model.Fatura;
import model.Filtro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AVLTest {
    Cliente cliente;
    Date date;

    public Cliente geraCliente(String nome, String sigla, Date date) {
        Estado estado = new Estado(sigla);
        return new Cliente(nome, date, estado);
    }

    @BeforeEach
    public void inicializaCliente() {
        date = Date.from(ZonedDateTime.now().toInstant());
        cliente = geraCliente("Leonardo", "PB", date);
    }

    public Date geraDataAntigaCom(int meses) {
        return Date.from(ZonedDateTime.now().minusMonths(meses).minusMinutes(5).toInstant());
    }

    @Test
    public void testeCriterio1() {
        List<Fatura> faturas = new ArrayList<>();

        faturas.add(new Fatura("333", 0.01, geraDataAntigaCom(0), cliente));
        faturas.add(new Fatura("334", 1000, geraDataAntigaCom(100), cliente));
        faturas.add(new Fatura("335", 1999, geraDataAntigaCom(1), cliente));

        assertEquals(0, Filtro.filtraFaturas(faturas).size());
    }

    @Test
    public void testeCriterio2() {
        List<Fatura> faturas = new ArrayList<>();

        Date dataAntiga = geraDataAntigaCom(2);
        faturas.add(new Fatura("333", 2000, dataAntiga, cliente));

        faturas.add(new Fatura("336", 2250, dataAntiga, cliente));

        faturas.add(new Fatura("338", 2500, dataAntiga, cliente));

        assertEquals(0, Filtro.filtraFaturas(faturas).size());
    }

    @Test
    public void testeCriterio3() {
        List<Fatura> faturas = new ArrayList<>();

        cliente = geraCliente("Leonardo", "PB", geraDataAntigaCom(3));

        faturas.add(new Fatura("335", 2500, geraDataAntigaCom(1), cliente));

        faturas.add(new Fatura("338", 2750, geraDataAntigaCom(2), cliente));

        faturas.add(new Fatura("302", 3000, geraDataAntigaCom(3), cliente));
        assertEquals(0, Filtro.filtraFaturas(faturas).size());
    }

    @Test
    public void testeCriterio4() {
        List<Fatura> faturas = new ArrayList<>();

        cliente = geraCliente("Leonardo", "SC", date);

        faturas.add(new Fatura("333", 4000.1, geraDataAntigaCom(0), cliente));
        faturas.add(new Fatura("302", 8000, geraDataAntigaCom(20), cliente));
        assertEquals(0, Filtro.filtraFaturas(faturas).size());
    }
}
