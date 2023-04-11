package br.com.android.projetobancoavancado.clinica.enums;

public enum SegmentoEnum {
    VAREJO("varejo"), TECNOLOGIA("tecnologia"),SAUDE("saude"), FINANCEIRO("financeiro"),
    AGRICULTURA("agricultura"), INDUSTRIA("industria"), TRANSPORTE("transporte"), ENERGIA("energia");

    String nome;

    SegmentoEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
