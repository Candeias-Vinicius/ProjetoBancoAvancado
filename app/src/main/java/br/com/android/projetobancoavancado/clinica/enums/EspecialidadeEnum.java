package br.com.android.projetobancoavancado.clinica.enums;

public enum EspecialidadeEnum {

    CARDIOLOGISTA("cardiologista"), NEUROLOGISTA("neurologista"), PSIQUIATRA("psiquiatra"), ENDOCRINOLOGISTA("endocrinologista"), DERMATOLOGISTA("dermatologista"), OFTALMOLOGISTA("oftalmologista");

    String nome;
    EspecialidadeEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
