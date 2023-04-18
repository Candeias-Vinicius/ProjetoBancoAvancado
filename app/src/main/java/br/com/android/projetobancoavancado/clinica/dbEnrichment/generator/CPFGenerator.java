package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.Random;

public class CPFGenerator {

    public static String generate(){

        String cpf = "";
        Random rand = new Random();

        for (int i = 1; i<=11; i++ ) {
            Integer digit = rand.nextInt(10);
            cpf = cpf.concat(digit.toString());
        }
        System.out.println(cpf);
        return cpf;
    }
}
