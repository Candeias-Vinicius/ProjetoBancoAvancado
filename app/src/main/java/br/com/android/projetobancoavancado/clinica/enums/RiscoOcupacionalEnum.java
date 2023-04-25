package br.com.android.projetobancoavancado.clinica.enums;

public enum RiscoOcupacionalEnum {

    QUIMICO("quimico"), FISICO("fisico"), BIOLOGICO("biologico");

    String nomeRisco;

    RiscoOcupacionalEnum(String nomeRisco) {
        this.nomeRisco = nomeRisco;
    }

    public String getNomeRisco() {
        return nomeRisco;
    }

    public void setNomeRisco(String nomeRisco) {
        this.nomeRisco = nomeRisco;
    }
}
