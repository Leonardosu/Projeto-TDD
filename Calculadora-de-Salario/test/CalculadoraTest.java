import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import org.junit.jupiter.api.Test;
import javax.management.InvalidAttributeValueException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Cargo;
import model.Funcionario;
import calculadora.Calculadora;

class CalculadoraTest {
    @Test
    void testDescontoDesenvolvedor() throws NotImplementedException {
        Cargo cargo = Cargo.DESENVOLVEDOR;
        double salario = 2000;
        double esperado = 0.10;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 3000;
        esperado = 0.20;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 10000;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));
    }

    @Test
    void testDescontoDBA() throws NotImplementedException {
        Cargo cargo = Cargo.DBA;
        double salario = 1000;
        double esperado = 0.15;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 2000;
        esperado = 0.25;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 10000;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));
    }

    @Test
    void testDescontoTESTADOR() throws NotImplementedException {
        Cargo cargo = Cargo.TESTADOR;
        double salario = 1000;
        double esperado = 0.15;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 2000;
        esperado = 0.25;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 10000;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));
    }

    @Test
    void testDescontoGERENTE() throws NotImplementedException {
        Cargo cargo = Cargo.GERENTE;
        double salario = 4000;
        double esperado = 0.20;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 5000;
        esperado = 0.30;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 10000;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));
    }

    private Funcionario getFuncionario(Cargo cargo, double salario) throws InvalidAttributeValueException {
        String nome = "Leonardo Su";
        String email = "leo123@gmail.com";
        return new Funcionario(nome, email, salario, cargo);
    }

    @Test
    void testSalarioFinal() throws InvalidAttributeValueException, NotImplementedException {
        double salario = 3000;
        Funcionario funcionario = getFuncionario(Cargo.DESENVOLVEDOR, salario);
        assertEquals(salario * (1 - 0.20), Calculadora.salarioFinal(funcionario));

        salario = 5000;
        funcionario = getFuncionario(Cargo.DBA, salario);
        assertEquals(salario * (1 - 0.25), Calculadora.salarioFinal(funcionario));

        funcionario = getFuncionario(Cargo.TESTADOR, salario);
        assertEquals(salario * (1 - 0.25), Calculadora.salarioFinal(funcionario));

        salario = 2000;
        funcionario = getFuncionario(Cargo.GERENTE, salario);
        assertEquals(salario * (1 - 0.20), Calculadora.salarioFinal(funcionario));
    }
}