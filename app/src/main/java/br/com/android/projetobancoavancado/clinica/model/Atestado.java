package br.com.android.projetobancoavancado.clinica.model;

import br.com.android.projetobancoavancado.clinica.enums.RiscoOcupacionalEnum;

public class Atestado {

    private Integer id;
    private Exame exame;
    private RiscoOcupacionalEnum riscoOcupacional;

    public Atestado(Integer id, Exame exame, RiscoOcupacionalEnum riscoOcupacional) {
        this.id = id;
        this.exame = exame;
        this.riscoOcupacional = riscoOcupacional;
    }

    public Atestado(Exame exame, RiscoOcupacionalEnum riscoOcupacional) {
        this.exame = exame;
        this.riscoOcupacional = riscoOcupacional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public RiscoOcupacionalEnum getRiscoOcupacional() {
        return riscoOcupacional;
    }

    public void setRiscoOcupacional(RiscoOcupacionalEnum riscoOcupacional) {
        this.riscoOcupacional = riscoOcupacional;
    }
}
