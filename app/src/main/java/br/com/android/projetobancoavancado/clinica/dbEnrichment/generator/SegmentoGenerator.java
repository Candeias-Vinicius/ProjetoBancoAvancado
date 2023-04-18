package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.SegmentoEnum;

public class SegmentoGenerator {

    public static SegmentoEnum generate() {
        Random random = new Random();

        Map<Integer, SegmentoEnum> mapaSegmentos = new HashMap<Integer,SegmentoEnum>();
        mapaSegmentos.put(1,SegmentoEnum.VAREJO);
        mapaSegmentos.put(2, SegmentoEnum.TRANSPORTE);
        mapaSegmentos.put(3, SegmentoEnum.TECNOLOGIA);
        mapaSegmentos.put(4, SegmentoEnum.SAUDE);
        mapaSegmentos.put(5, SegmentoEnum.INDUSTRIA);
        mapaSegmentos.put(6, SegmentoEnum.FINANCEIRO);
        mapaSegmentos.put(7, SegmentoEnum.ENERGIA);
        mapaSegmentos.put(8, SegmentoEnum.AGRICULTURA);

        int randomKey = random.nextInt(7) + 1;

        return mapaSegmentos.get(randomKey);

    }
}
