package functionalTests;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import model.Cargo;
import model.Funcionario;
import calculadora.Calculadora;

import static org.junit.jupiter.api.Assertions.*;

public class AVLTest {
    static Funcionario funcionario;
    final static double eps = 0.00001;

    private void setInfo(double salario, Cargo cargo) {
        funcionario.setSalario(salario);
        funcionario.setCargo(cargo);
    }

    @BeforeAll
    public static void init() {
        try {
            funcionario = new Funcionario("fulano", "abc@abc.com", 0, Cargo.GERENTE);
        } catch (Exception e) {

        }
    }

    @Test
    void desenvolvedorTest1() {
        try {
            setInfo(4000, Cargo.DESENVOLVEDOR);
            assertEquals(3200, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void desenvolvedorTest2() {
        try {
            setInfo(3000, Cargo.DESENVOLVEDOR);
            assertEquals(2400, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void desenvolvedorTest3() {
        try {
            setInfo(2999, Cargo.DESENVOLVEDOR);
            assertEquals(2699.1, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void desenvolvedorTest4() {
        setInfo(-1, Cargo.DESENVOLVEDOR);
        assertThrows(IllegalArgumentException.class, () -> Calculadora.salarioFinal(funcionario));
    }
    @Test
    void DBATest1() {
        try {
            setInfo(3000, Cargo.DBA);
            assertEquals(2250, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void DBATest2() {
        try {
            setInfo(2000, Cargo.DBA);
            assertEquals(1500, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void DBATest3() {
        try {
            setInfo(1999, Cargo.DBA);
            assertEquals(1699.15, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void DBATest4() {
        setInfo(-1, Cargo.DBA);
        assertThrows(IllegalArgumentException.class, () -> Calculadora.salarioFinal(funcionario));
    }
    @Test
    void TestadorTest1() {
        try {
            setInfo(3000, Cargo.TESTADOR);
            assertEquals(2250, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void TestadorTest2() {
        try {
            setInfo(2000, Cargo.TESTADOR);
            assertEquals(1500, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void TestadorTest3() {
        try {
            setInfo(1999, Cargo.TESTADOR);
            assertEquals(1699.15, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void TestadorTest4() {
        setInfo(-1, Cargo.TESTADOR);
        assertThrows(IllegalArgumentException.class, () -> Calculadora.salarioFinal(funcionario));
    }
    @Test
    void GerenteTest1() {
        try {
            setInfo(6000, Cargo.GERENTE);
            assertEquals(4200, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void GerenteTest2() {
        try {
            setInfo(5000, Cargo.GERENTE);
            assertEquals(3500, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void GerenteTest3() {
        try {
            setInfo(4999, Cargo.GERENTE);
            assertEquals(3999.2, Calculadora.salarioFinal(funcionario), eps);
        } catch (NotImplementedException e) {
            fail();
        }
    }
    @Test
    void GerenteTest4() {
        setInfo(-1, Cargo.GERENTE);
        assertThrows(IllegalArgumentException.class, () -> Calculadora.salarioFinal(funcionario));
    }
}
