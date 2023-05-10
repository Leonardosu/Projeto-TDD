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

public class PETest {
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
    public void testeFaturaValorMenorQue2000() {
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(new Fatura("335", 1500, geraDataAntigaCom(1), cliente));
        assertEquals(0, Filtro.filtraFaturas(faturas).size());
        faturas = Filtro.filtraFaturas(faturas);
        assertEquals(0, faturas.size());

        faturas.add(new Fatura("335", 2000, geraDataAntigaCom(0), cliente));
        assertEquals(1, Filtro.filtraFaturas(faturas).size());
    }

    @Test
    public void testFaturaValorEntre2000e2500ComDataHaMaisDeUmMes() {
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(new Fatura("335", 2000, geraDataAntigaCom(2), cliente));
        faturas = Filtro.filtraFaturas(faturas);
        assertEquals(0, faturas.size());

        faturas.add(new Fatura("335", 2300, geraDataAntigaCom(0), cliente));
        assertEquals(1, Filtro.filtraFaturas(faturas).size());
    }
    @Test
    public void testFaturaValorEntre2500e3000ComClienteHaMenosDeDoisMeses() {
        List<Fatura> faturas = new ArrayList<>();

        cliente = geraCliente("Leonardo", "PB", geraDataAntigaCom(2));
        faturas.add(new Fatura("335", 2800, geraDataAntigaCom(2), cliente));
        faturas = Filtro.filtraFaturas(faturas);
        assertEquals(0, faturas.size());

        cliente = geraCliente("Leonardo", "PB", geraDataAntigaCom(1));
        faturas.add(new Fatura("335", 2600, geraDataAntigaCom(3), cliente));
        assertEquals(1, Filtro.filtraFaturas(faturas).size());
    }

    @Test
    public void testRemoverFaturaValorMaiorQue4000DoEstadoDoSul() {
        List<Fatura> faturas = new ArrayList<>();

        cliente = geraCliente("Leonardo", "SC", date);
        faturas.add(new Fatura("333", 4000.1, geraDataAntigaCom(0), cliente));
        faturas = Filtro.filtraFaturas(faturas);
        assertEquals(0, faturas.size());

        cliente = geraCliente("Leonardo", "PB", date);
        faturas.add(new Fatura("302", 8000, geraDataAntigaCom(20), cliente));
        assertEquals(1, Filtro.filtraFaturas(faturas).size());
    }
}
