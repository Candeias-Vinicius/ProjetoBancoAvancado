package br.com.android.projetobancoavancado.clinica.model;

import br.com.android.projetobancoavancado.clinica.enums.RiscoOcupacionalEnum;

public class EmpresaRiscoOcupacional {
    private RiscoOcupacionalEnum riscoOcupacional;
    private int total;

    public EmpresaRiscoOcupacional( RiscoOcupacionalEnum riscoOcupacional, int total) {

        this.riscoOcupacional = riscoOcupacional;
        this.total = total;
    }

    public RiscoOcupacionalEnum getRiscoOcupacional() {
        return riscoOcupacional;
    }

    public int getTotal() {
        return total;
    }
}


