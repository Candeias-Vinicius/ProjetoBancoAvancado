package br.com.android.projetobancoavancado.clinica.model;

import java.util.Objects;

public class Paciente {

    private Integer id;
    private String cpf;
    private String nome;
    private Empresa empresa;
    private Cargo cargo;

    public Paciente(Integer id, String cpf, String nome, Empresa empresa, Cargo cargo) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.empresa = empresa;
        this.cargo = cargo;
    }

    public Paciente(String cpf, String nome, Empresa empresa, Cargo cargo) {

        this.cpf = cpf;
        this.nome = nome;
        this.empresa = empresa;
        this.cargo = cargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(cpf, paciente.cpf) && Objects.equals(nome, paciente.nome) && Objects.equals(empresa, paciente.empresa) && Objects.equals(cargo, paciente.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome, empresa, cargo);
    }
}
