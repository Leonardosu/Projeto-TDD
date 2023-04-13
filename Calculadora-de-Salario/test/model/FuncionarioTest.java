package model;

import org.junit.jupiter.api.Test;
import javax.management.InvalidAttributeValueException;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {
    @Test
    void testConstructor() {
        String nome = "leonardo su";
        String email = "leo@gmail.com";
        double salario = 3000;
        Cargo cargo = Cargo.GERENTE;

        try {
            new Funcionario(null, email, salario, cargo);
            fail("Esperado uma exceção por nome nulo");
        } catch (InvalidAttributeValueException ignored) {}

        try {
            new Funcionario(nome, null, salario, cargo);
            fail("Esperado uma exceção por email nulo");
        } catch (InvalidAttributeValueException ignored) {}

        try {
            new Funcionario(nome, email, -1, cargo);
            fail("Esperado uma exceção salario inválido");
        } catch (InvalidAttributeValueException ignored) {}
    }


}