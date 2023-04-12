import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class FiltroTest {

    Cliente cliente;
    Date data;
    Estado pb;
    List<Fatura> listaVazia;

    @BeforeEach
    public void setup() {
        data = new Date();
        pb = new Estado("PB");
        cliente = new Cliente("fulano", data, pb);
        listaVazia = new ArrayList<>();
    }

    @Test
    public void testListaVazia() {
        List<Fatura> faturas = new ArrayList<>();
        assertEquals(listaVazia, Filtro.filtraFaturas(faturas));
    }

    @Test
    public void testValorMenorDoisMil() {
        List<Fatura> faturas = new ArrayList<>();
        Fatura fatura = new Fatura("333", 1500, data, cliente);
        faturas.add(fatura);
        assertEquals(listaVazia, Filtro.filtraFaturas(faturas));
    }

    @Test
    public void testUmMesAtras() {
        List<Fatura> faturas = new ArrayList<>();
        Date date = Date.from(ZonedDateTime.now().minusMonths(2).toInstant());
        Fatura fatura = new Fatura("333", 2300, date, cliente);
        faturas.add(fatura);
        assertEquals(listaVazia, Filtro.filtraFaturas(faturas));
    }

    @Test
    public void testInclusao() {
        List<Fatura> faturas = new ArrayList<>();
        Date date = Date.from(ZonedDateTime.now().minusMonths(3).toInstant());
        Cliente cliente1 = new Cliente("beltrano", date, pb);
        Fatura fatura = new Fatura("333", 2700, data, cliente1);
        faturas.add(fatura);
        assertEquals(listaVazia, Filtro.filtraFaturas(faturas));
    }

    @Test
    public void testRegiaoSul() {
        List<Fatura> faturas = new ArrayList<>();
        Estado sc = new Estado("SC");
        Cliente cliente1 = new Cliente("beltrano", data, sc);
        Fatura fatura = new Fatura("333", 7000, data, cliente1);
        faturas.add(fatura);
        assertEquals(listaVazia, Filtro.filtraFaturas(faturas));
    }
}