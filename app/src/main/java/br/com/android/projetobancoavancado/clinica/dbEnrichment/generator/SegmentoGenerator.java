package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.SegmentoEnum;

public class SegmentoGenerator {

    public static SegmentoEnum generate() {
        Random random = new Random();

        List<SegmentoEnum> segmentos = new ArrayList<>();

        segmentos.add(SegmentoEnum.VAREJO);
        segmentos.add(SegmentoEnum.TRANSPORTE);
        segmentos.add(SegmentoEnum.TECNOLOGIA);
        segmentos.add(SegmentoEnum.SAUDE);
        segmentos.add(SegmentoEnum.INDUSTRIA);
        segmentos.add(SegmentoEnum.FINANCEIRO);
        segmentos.add(SegmentoEnum.ENERGIA);
        segmentos.add(SegmentoEnum.AGRICULTURA);


        int randomKey = random.nextInt(8) ;

        return segmentos.get(randomKey);

    }
}
