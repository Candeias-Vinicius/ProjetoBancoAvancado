package br.com.android.projetobancoavancado.clinica.dbEnrichment;

import com.github.javafaker.Faker;

import java.util.Random;

//Classe de testes
public class JavaFakerSandbox {
    private static Faker faker = new Faker();

    public static void main(String[] args) {

        String profissao = faker.company().profession();
        Random r = new Random();


        System.out.println(r.nextInt(1));

    }
}
