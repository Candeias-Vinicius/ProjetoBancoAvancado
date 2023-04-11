package br.com.android.projetobancoavancado.clinica.model;

import br.com.android.projetobancoavancado.clinica.enums.RiscoOcupacionaEnum;

public class Atestado {

    private Integer id;
    private Exame exame;
    private RiscoOcupacionaEnum riscoOcupacional;

    public Atestado(Integer id, Exame exame, RiscoOcupacionaEnum riscoOcupacional) {
        this.id = id;
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

    public RiscoOcupacionaEnum getRiscoOcupacional() {
        return riscoOcupacional;
    }

    public void setRiscoOcupacional(RiscoOcupacionaEnum riscoOcupacional) {
        this.riscoOcupacional = riscoOcupacional;
    }
}
