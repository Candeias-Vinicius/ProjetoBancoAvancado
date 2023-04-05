package br.com.android.projetobancoavancado.model;

public enum Tipo_Exame_Enum {
    ADMISSIONAL("Admissional"), PERIODICO("Periodico"), RETORNO_AO_TRABALHO("Retorno ao trabalho"),
    DEMISSIONAL("Demissional"), TRANSFERENCIA_DE_FUNCAO("Transferencia de Função");

    String nome;
    Tipo_Exame_Enum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
