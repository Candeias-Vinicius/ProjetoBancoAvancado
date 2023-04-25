package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.TipoExameEnum;
import br.com.android.projetobancoavancado.clinica.model.Exame;
import br.com.android.projetobancoavancado.clinica.model.Medico;
import br.com.android.projetobancoavancado.clinica.model.Paciente;

public class ExameGenerator {
    private static final Random random = new Random();

    public static Exame generate(int numExames, int numPacientes, int numEmpresas, int numCargos, int numMedicos){
        int id = random.nextInt(numExames + 1);
        Paciente paciente = PacienteGenerator.generate(numPacientes, numEmpresas, numCargos);
        Medico medico = MedicoGenerator.generate(numMedicos);
        Date data = new Date();
        return new Exame(id, medico, paciente, "", TipoExameEnum.ADMISSIONAL, data);
    }
}
