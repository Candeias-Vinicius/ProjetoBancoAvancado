package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.RiscoOcupacionalEnum;

public class RiscoOcupacionalGenerator {

    public static RiscoOcupacionalEnum generate() {
        Random random = new Random();

        Map<Integer, RiscoOcupacionalEnum> mapaRiscos = new HashMap<Integer, RiscoOcupacionalEnum>();
        mapaRiscos.put(1, RiscoOcupacionalEnum.BIOLOGICO);
        mapaRiscos.put(2, RiscoOcupacionalEnum.FISICO);
        mapaRiscos.put(3, RiscoOcupacionalEnum.QUIMICO);



        int randomKey = random.nextInt(2) + 1;

        return mapaRiscos.get(randomKey);

    }
}
