package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.Random;

public class CRMGenerator {

    public static String generate(){

        String crm = "";
        Random rand = new Random();

        for (int i = 1; i<=12; i++ ) {
            Integer digit = rand.nextInt(10);
            crm = crm.concat(digit.toString());
        }
        System.out.println(crm);
        return crm;
    }
}
