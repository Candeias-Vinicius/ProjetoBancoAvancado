package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.Random;

import br.com.android.projetobancoavancado.clinica.model.Cargo;

public class CargoGenerator {

    private static final Random random = new Random();

    public static Cargo generate(int numCargos) {

        int id = random.nextInt(numCargos + 1);
        return new Cargo(id, "");
    }
}
