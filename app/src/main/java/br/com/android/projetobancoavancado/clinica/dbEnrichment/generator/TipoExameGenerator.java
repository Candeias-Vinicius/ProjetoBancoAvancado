package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.RiscoOcupacionalEnum;
import br.com.android.projetobancoavancado.clinica.enums.TipoExameEnum;

public class TipoExameGenerator {
    public static TipoExameEnum generate() {
        Random random = new Random();

        List<TipoExameEnum> tiposExames = new ArrayList<>();

        tiposExames.add(TipoExameEnum.PERIODICO);
        tiposExames.add(TipoExameEnum.ADMISSIONAL);
        tiposExames.add(TipoExameEnum.DEMISSIONAL);
        tiposExames.add(TipoExameEnum.RETORNO_AO_TRABALHO);
        tiposExames.add(TipoExameEnum.TRANSFERENCIA_DE_FUNCAO);

        int randomKey = random.nextInt(5) ;

        return tiposExames.get(randomKey);

    }
}
