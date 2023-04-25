package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.EspecialidadeEnum;
import br.com.android.projetobancoavancado.clinica.model.Medico;

public class MedicoGenerator {

    private static final Random random = new Random();

    public static Medico generate(int numMedicos){
        int id = random.nextInt(numMedicos + 1);
        Medico medico = new Medico(id, "", "","", EspecialidadeEnum.CARDIOLOGISTA);
        return medico;
    }
}
