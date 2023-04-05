package br.com.android.projetobancoavancado.model;

import java.util.Objects;

public class Empresa {

    private Integer cnpj;
    private String nome;
    private String segmento;

    public Empresa(Integer cnpj, String nome, String segmento) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.segmento = segmento;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(cnpj, empresa.cnpj) && Objects.equals(nome, empresa.nome) && Objects.equals(segmento, empresa.segmento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, nome, segmento);
    }
}
