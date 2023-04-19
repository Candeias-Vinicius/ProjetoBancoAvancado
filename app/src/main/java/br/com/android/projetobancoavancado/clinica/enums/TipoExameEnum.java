package br.com.android.projetobancoavancado.clinica.enums;

public enum TipoExameEnum {
    ADMISSIONAL("Admissional"), PERIODICO("Periodico"), RETORNO_AO_TRABALHO("Retorno ao trabalho"),
    DEMISSIONAL("Demissional"), TRANSFERENCIA_DE_FUNCAO("Transferencia de Função");

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
