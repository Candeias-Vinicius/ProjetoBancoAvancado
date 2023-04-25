package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.Random;

import br.com.android.projetobancoavancado.clinica.enums.SegmentoEnum;
import br.com.android.projetobancoavancado.clinica.model.Empresa;

public class EmpresaGenerator {
    private static final Random random = new Random();

    public static Empresa generate(int numEmpresas){

        int id = random.nextInt(numEmpresas + 1);
        return new Empresa(id, "","", SegmentoEnum.AGRICULTURA);
    }
}
