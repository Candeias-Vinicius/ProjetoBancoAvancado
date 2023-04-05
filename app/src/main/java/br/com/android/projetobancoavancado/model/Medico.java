package br.com.android.projetobancoavancado.model;

import java.util.Objects;

public class Medico {

    private Integer id;
    private Integer crm;
    private String nome;
    private String email;
    private EspecialidadeEnum especialidadeEnum;

    public Medico(Integer crm, String nome, String email, EspecialidadeEnum especialidadeEnum) {
        this.crm = crm;
        this.nome = nome;
        this.email = email;
        this.especialidadeEnum = especialidadeEnum;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EspecialidadeEnum getEspecialidade() {
        return especialidadeEnum;
    }

    public void setEspecialidade(EspecialidadeEnum especialidadeEnum) {
        this.especialidadeEnum = especialidadeEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(crm, medico.crm) && Objects.equals(nome, medico.nome) && Objects.equals(email, medico.email) && Objects.equals(especialidadeEnum, medico.especialidadeEnum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crm, nome, email, especialidadeEnum);
    }
}
