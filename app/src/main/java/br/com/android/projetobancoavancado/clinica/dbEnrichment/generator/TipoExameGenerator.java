package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.EspecialidadeEnum;
import br.com.android.projetobancoavancado.clinica.enums.Tipo_Exame_Enum;

public class TipoExameGenerator {
    public static Tipo_Exame_Enum generate() {
        Random random = new Random();

        Map<Integer, Tipo_Exame_Enum> mapaTipoExames = new HashMap<Integer, Tipo_Exame_Enum>();
        mapaTipoExames.put(1, Tipo_Exame_Enum.ADMISSIONAL);
        mapaTipoExames.put(2, Tipo_Exame_Enum.DEMISSIONAL);
        mapaTipoExames.put(3, Tipo_Exame_Enum.PERIODICO);
        mapaTipoExames.put(4, Tipo_Exame_Enum.RETORNO_AO_TRABALHO);
        mapaTipoExames.put(5, Tipo_Exame_Enum.TRANSFERENCIA_DE_FUNCAO);

        int randomKey = random.nextInt(4) + 1;

        return mapaTipoExames.get(randomKey);

    }
}
