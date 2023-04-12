import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class EstadoTest {
    @Test
    public void testSiglaInvalida() {
        try {
            Estado e = new Estado(null);
            fail("Estado com sigla nula não deveria ser instanciado");
        } catch (Exception e) {
        }
        try {
            Estado e = new Estado("");
            fail("Estado com sigla vazia não deveria ser instanciado");
        } catch (Exception e) {
        }
        try {
            Estado e = new Estado("XY");
            fail("Estado com sigla inválida não deveria ser instanciado");
        } catch (Exception e) {
        }
    }

    @Test
    public void testRegiao() {
        Estado pb = new Estado("PB");
        assertEquals(pb.regiao, Regiao.NORDESTE);
        Estado sp = new Estado("SP");
        assertEquals(sp.regiao, Regiao.SUDESTE);
        Estado sc = new Estado("SC");
        assertEquals(sc.regiao, Regiao.SUL);
        Estado am = new Estado("AM");
        assertEquals(am.regiao, Regiao.NORTE);
        Estado mt = new Estado("MT");
        assertEquals(mt.regiao, Regiao.CENTRO_OESTE);
    }
}
