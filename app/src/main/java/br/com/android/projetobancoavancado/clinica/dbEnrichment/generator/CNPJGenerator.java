package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.Random;

public class CNPJGenerator {

    public static String generate(){

        String cnpj = "";
        Random rand = new Random();

        for (int i = 1; i<=14; i++ ) {
            Integer digit = rand.nextInt(10);
            cnpj = cnpj.concat(digit.toString());
        }
        System.out.println(cnpj);
        return cnpj;
    }
}
