package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.RiscoOcupacionalEnum;

public class RiscoOcupacionalGenerator {

    public static RiscoOcupacionalEnum generate() {
        Random random = new Random();

        List<RiscoOcupacionalEnum> riscosOcupacionais = new ArrayList<>();

        riscosOcupacionais.add(RiscoOcupacionalEnum.BIOLOGICO);
        riscosOcupacionais.add(RiscoOcupacionalEnum.FISICO);
        riscosOcupacionais.add(RiscoOcupacionalEnum.QUIMICO);

        int randomKey = random.nextInt(3);

        return riscosOcupacionais.get(randomKey);

    }
}
