package br.com.android.projetobancoavancado.model;

import java.util.Objects;

public class Paciente {

    private Integer id;
    private Integer cpf;
    private String nome;
    private Empresa empresa;
    private Cargo cargo;

    public Paciente(Integer cpf, String nome, Empresa empresa, Cargo cargo) {

        this.cpf = cpf;
        this.nome = nome;
        this.empresa = empresa;
        this.cargo = cargo;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
