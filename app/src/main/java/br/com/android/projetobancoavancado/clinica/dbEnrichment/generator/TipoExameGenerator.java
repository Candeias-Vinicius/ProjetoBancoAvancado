package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.TipoExameEnum;

public class TipoExameGenerator {
    public static TipoExameEnum generate() {
        Random random = new Random();

        Map<Integer, TipoExameEnum> mapaTipoExames = new HashMap<Integer, TipoExameEnum>();
        mapaTipoExames.put(1, TipoExameEnum.ADMISSIONAL);
        mapaTipoExames.put(2, TipoExameEnum.DEMISSIONAL);
        mapaTipoExames.put(3, TipoExameEnum.PERIODICO);
        mapaTipoExames.put(4, TipoExameEnum.RETORNO_AO_TRABALHO);
        mapaTipoExames.put(5, TipoExameEnum.TRANSFERENCIA_DE_FUNCAO);

        int randomKey = random.nextInt(4) + 1;

        return mapaTipoExames.get(randomKey);

    }
}
