package br.com.android.projetobancoavancado.clinica.model;

import java.util.Date;
import java.util.Objects;

import br.com.android.projetobancoavancado.clinica.enums.TipoExameEnum;

public class Exame {

    private Integer id;
    private Medico medico;
    private Paciente paciente;
    private String resultado;
    private TipoExameEnum tipo_exame;
    private Date data;

    public Exame(Integer id, Medico medico, Paciente paciente, String resultado, TipoExameEnum tipo_exame, Date data) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.resultado = resultado;
        this.tipo_exame = tipo_exame;
        this.data = data;
    }

    public Exame(Medico medico, Paciente paciente, String resultado, TipoExameEnum tipo_exame, Date data) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.resultado = resultado;
        this.tipo_exame = tipo_exame;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public TipoExameEnum getTipo_exame() {
        return tipo_exame;
    }

    public void setTipo_exame(TipoExameEnum tipo_exame) {
        this.tipo_exame = tipo_exame;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exame exame = (Exame) o;
        return Objects.equals(id, exame.id) && Objects.equals(medico, exame.medico) && Objects.equals(paciente, exame.paciente) && Objects.equals(resultado, exame.resultado) && Objects.equals(tipo_exame, exame.tipo_exame) && Objects.equals(data, exame.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, medico, paciente, resultado, tipo_exame, data);
    }
}
