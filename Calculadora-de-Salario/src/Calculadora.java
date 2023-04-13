import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import model.Cargo;
import model.Funcionario;

public class Calculadora {
    public static double salarioFinal(Funcionario funcionario) throws NotImplementedException {
        double salario = funcionario.getSalario();
        Cargo cargo = funcionario.getCargo();

        double desconto = getDesconto(salario, cargo);
        return salario * (1.0 - desconto);
    }

    public static double getDesconto(double salario, Cargo cargo) throws NotImplementedException {
        double desconto;
        double limite;

        switch (cargo) {
            case DESENVOLVEDOR -> {
                limite = 3000.0;
                desconto = (salario >= limite ? 20 : 10);
            }
            case DBA, TESTADOR -> {
                limite = 2000.0;
                desconto = (salario >= limite ? 25 : 15);
            }
            case GERENTE -> {
                limite = 5000.0;
                desconto = (salario >= limite ? 30 : 20);
            }
        }

        return desconto / 100.0;
    }

}
