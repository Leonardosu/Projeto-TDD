import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filtro {
    public static List<Fatura> filtraFaturas(List<Fatura> faturas) {
        List<Fatura> ans = new ArrayList<>();
        for (Fatura fatura : faturas) {
            if (!precisaRemover(fatura)) {
                ans.add(fatura);
            }
        }
        return ans;
    }

    private static boolean precisaRemover(Fatura fatura) {
        if (fatura.valor < 2000) return true;
        if (fatura.valor <= 2500) {
            Date umMesAtras = Date.from(ZonedDateTime.now().minusMonths(1).toInstant());
            return fatura.date.before(umMesAtras);
        }
        if (fatura.valor <= 3000) {
            Date doisMesesAtras = Date.from(ZonedDateTime.now().minusMonths(2).toInstant());
            return fatura.cliente.dataDeInclusao.before(doisMesesAtras);
        }
        if (fatura.valor > 4000) {
            return fatura.cliente.estado.regiao == Regiao.SUL;
        }
        return false;
    }
}
