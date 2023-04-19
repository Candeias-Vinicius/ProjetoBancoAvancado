package br.com.android.projetobancoavancado.clinica.enums;

public enum RiscoOcupacionalEnum {

    QUIMICO("Quimico"), FISICO("Fisico"), BIOLOGICO("Biologico");

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
