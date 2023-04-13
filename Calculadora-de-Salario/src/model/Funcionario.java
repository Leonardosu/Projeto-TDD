package model;

import javax.management.InvalidAttributeValueException;

public class Funcionario {
    private final String nome;
    private String email;
    private double salario;
    private Cargo cargo;

    public Funcionario(String nome, String email, double salario, Cargo cargo) throws InvalidAttributeValueException {
        if(salario < 0) {
            throw new InvalidAttributeValueException("Salario negativo");
        } else if(nome == null || nome.isEmpty()) {
            throw new InvalidAttributeValueException("Nome nulo ou vazio");
        } else if(email == null || email.isEmpty()) {
            throw new InvalidAttributeValueException("Email nulo ou vazio");
        }

        this.nome = nome;
        this.email = email;
        this.salario = salario;
        this.cargo = cargo;


    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setCargo(Cargo novoCargo) {
        cargo = novoCargo;
    }

    public void setSalario(double novoSalario) {
        salario = novoSalario;
    }

    public void setEmail(String novoEmail) {
        email = novoEmail;
    }

    public String getEmail() {
        return email;
    }
}
