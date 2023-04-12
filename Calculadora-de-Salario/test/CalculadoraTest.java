import model.Cargo;
import model.Funcionario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {
    private Funcionario getFuncinario(Cargo cargo, double salario) {
        String nome = "Leonardo Su";
        String email = "leo123@gmail.com";
        return new Funcionario(nome, email, salario, cargo);
    }

    @Test
    void testDescontoDesenvolvedor() {
        Cargo cargo = Cargo.DESENVOLVEDOR;
        double salario = 2000;
        double esperado = 10;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 3000;
        esperado = 20;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 10000;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));
    }

    @Test
    void testDescontoDBA() {
        Cargo cargo = Cargo.DBA;
        double salario = 1000;
        double esperado = 15;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 2000;
        esperado = 25;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 10000;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));
    }

    @Test
    void testDescontoTESTADOR() {
        Cargo cargo = Cargo.TESTADOR;
        double salario = 1000;
        double esperado = 15;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 2000;
        esperado = 25;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 10000;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));
    }

    @Test
    void testDescontoGERENTE() {
        Cargo cargo = Cargo.GERENTE;
        double salario = 4000;
        double esperado = 20;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 5000;
        esperado = 30;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));

        salario = 10000;
        assertEquals(esperado, Calculadora.getDesconto(salario, cargo));
    }

    @Test
    void testSalarioFinal() {
        double salario = 3000;
        Funcionario funcionario = getFuncinario(Cargo.DESENVOLVEDOR, salario);
        assertEquals(salario * (100 - 20), Calculadora.salarioFinal(funcionario));

        salario = 5000;
        funcionario = getFuncinario(Cargo.DBA, salario);
        assertEquals(salario * (100 - 25), Calculadora.salarioFinal(funcionario));

        funcionario = getFuncinario(Cargo.TESTADOR, salario);
        assertEquals(salario * (100 - 25), Calculadora.salarioFinal(funcionario));

        salario = 2000;
        funcionario = getFuncinario(Cargo.GERENTE, salario);
        assertEquals(salario * (100 - 20), Calculadora.salarioFinal(funcionario));
    }
}