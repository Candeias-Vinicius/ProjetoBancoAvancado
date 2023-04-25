package br.com.android.projetobancoavancado.clinica.enums;

public enum TipoExameEnum {
    ADMISSIONAL("admissional"), PERIODICO("periodico"), RETORNO_AO_TRABALHO("retorno_ao_trabalho"),
    DEMISSIONAL("demissional"), TRANSFERENCIA_DE_FUNCAO("transferencia_de_Função");

    String nome;
    TipoExameEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
