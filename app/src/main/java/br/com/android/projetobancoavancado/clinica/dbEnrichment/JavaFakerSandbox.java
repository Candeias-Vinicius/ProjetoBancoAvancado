package br.com.android.projetobancoavancado.clinica.dbEnrichment;

import com.github.javafaker.Faker;

//Classe de testes
public class JavaFakerSandbox {
    private static Faker faker = new Faker();

    public static void main(String[] args) {

        String profissao = faker.company().profession();

        System.out.println(profissao);
    }
}
