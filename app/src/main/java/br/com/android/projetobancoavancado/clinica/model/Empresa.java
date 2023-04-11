package br.com.android.projetobancoavancado.clinica.model;

import java.util.Objects;

import br.com.android.projetobancoavancado.clinica.enums.SegmentoEnum;

public class Empresa {

    private Integer id;
    private String cnpj;
    private String nome;
    private SegmentoEnum segmento;

    public Empresa(Integer id, String cnpj, String nome, SegmentoEnum segmento) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.segmento = segmento;
    }

    public Empresa(String cnpj, String nome, SegmentoEnum segmento) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.segmento = segmento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SegmentoEnum getSegmento() {
        return segmento;
    }

    public void setSegmento(SegmentoEnum segmento) {
        this.segmento = segmento;
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
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id) && Objects.equals(cnpj, empresa.cnpj) && Objects.equals(nome, empresa.nome) && Objects.equals(segmento, empresa.segmento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj, nome, segmento);
    }
}
