package model;

public class Funcionario {
    private final String nome;
    private String email;
    private double salario;
    private Cargo cargo;

    public Funcionario(String nome, String email, double salario, Cargo cargo) {
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
