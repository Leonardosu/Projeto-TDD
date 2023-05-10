import model.Estado;
import model.Regiao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EstadoTest {
    @Test
    public void testSiglaInvalida() {
        try {
            Estado e = new Estado(null);
            fail("model.Estado com sigla nula não deveria ser instanciado");
        } catch (Exception e) {
        }
        try {
            Estado e = new Estado("");
            fail("model.Estado com sigla vazia não deveria ser instanciado");
        } catch (Exception e) {
        }
        try {
            Estado e = new Estado("XY");
            fail("model.Estado com sigla inválida não deveria ser instanciado");
        } catch (Exception e) {
        }
    }

    @Test
    public void testRegiao() {
        Estado pb = new Estado("PB");
        assertEquals(pb.getRegiao(), Regiao.NORDESTE);
        Estado sp = new Estado("SP");
        assertEquals(sp.getRegiao(), Regiao.SUDESTE);
        Estado sc = new Estado("SC");
        assertEquals(sc.getRegiao(), Regiao.SUL);
        Estado am = new Estado("AM");
        assertEquals(am.getRegiao(), Regiao.NORTE);
        Estado mt = new Estado("MT");
        assertEquals(mt.getRegiao(), Regiao.CENTRO_OESTE);
    }
}
