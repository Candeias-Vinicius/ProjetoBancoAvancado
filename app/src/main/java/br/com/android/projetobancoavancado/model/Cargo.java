package br.com.android.projetobancoavancado.model;

import java.util.Objects;

public class Cargo {

    private Integer id;
    private String descricao;

    public Cargo(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(id, cargo.id) && Objects.equals(descricao, cargo.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}
