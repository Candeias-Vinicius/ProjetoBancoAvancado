package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.EspecialidadeEnum;
import br.com.android.projetobancoavancado.clinica.enums.SegmentoEnum;

public class EspecialidadeGenerator {
    public static EspecialidadeEnum generate() {
        Random random = new Random();

        Map<Integer, EspecialidadeEnum> mapaEspecialidades = new HashMap<Integer, EspecialidadeEnum>();
        mapaEspecialidades.put(1, EspecialidadeEnum.DERMATOLOGISTA);
        mapaEspecialidades.put(2, EspecialidadeEnum.ENDOCRINOLOGISTA);
        mapaEspecialidades.put(3, EspecialidadeEnum.OFTALMOLOGISTA);
        mapaEspecialidades.put(4, EspecialidadeEnum.PSIQUIATRA);
        mapaEspecialidades.put(5, EspecialidadeEnum.CARDIOLOGISTA);
        mapaEspecialidades.put(6, EspecialidadeEnum.NEUROLOGISTA);

        int randomKey = random.nextInt(5) + 1;

        return mapaEspecialidades.get(randomKey);

    }
}
