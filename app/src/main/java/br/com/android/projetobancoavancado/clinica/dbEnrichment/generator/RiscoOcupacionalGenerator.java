package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.EspecialidadeEnum;
import br.com.android.projetobancoavancado.clinica.enums.RiscoOcupacionaEnum;

public class RiscoOcupacionalGenerator {

    public static RiscoOcupacionaEnum generate() {
        Random random = new Random();

        Map<Integer, RiscoOcupacionaEnum> mapaRiscos = new HashMap<Integer, RiscoOcupacionaEnum>();
        mapaRiscos.put(1, RiscoOcupacionaEnum.BIOLOGICO);
        mapaRiscos.put(2, RiscoOcupacionaEnum.FISICO);
        mapaRiscos.put(3, RiscoOcupacionaEnum.QUIMICO);



        int randomKey = random.nextInt(2) + 1;

        return mapaRiscos.get(randomKey);

    }
}
