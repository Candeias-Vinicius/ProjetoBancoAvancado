package br.com.android.projetobancoavancado.clinica.dbEnrichment;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.CNPJGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.CPFGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.CRMGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.EspecialidadeGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.RiscoOcupacionalGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.SegmentoGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.TipoExameGenerator;
import br.com.android.projetobancoavancado.clinica.enums.EspecialidadeEnum;
import br.com.android.projetobancoavancado.clinica.enums.RiscoOcupacionaEnum;
import br.com.android.projetobancoavancado.clinica.enums.SegmentoEnum;
import br.com.android.projetobancoavancado.clinica.enums.Tipo_Exame_Enum;
import br.com.android.projetobancoavancado.clinica.model.Empresa;
import br.com.android.projetobancoavancado.clinica.util.DBHelper;

public class DBPopulator {
    Faker faker = new Faker();

    public void popularBanco() {

        criarEmpresas();
        criarCargos();
        criarMedicos();
        criarPacientes();
        criarExames();
        criarAtestados();

    }

    //TODO codar inserts e envolver em estruturas de repetição
    private void criarEmpresas() {
        String cnpj = CNPJGenerator.generate();
        String nome = faker.company().name();
        SegmentoEnum segmento = SegmentoGenerator.generate();

        Empresa empresa = new Empresa(cnpj, nome, segmento);

    }
    private void criarCargos() {
        String nome = faker.company().profession();
    }
    private void criarPacientes() {

        String nome = faker.name().fullName();
        String cpf = CPFGenerator.generate();
        //TODO add empresa e cargo

    }

    private void criarMedicos(){
        String crm = CRMGenerator.generate();
        String nome = faker.name().fullName();
        String email = faker.internet().emailAddress();
        EspecialidadeEnum especialidade = EspecialidadeGenerator.generate();

    }

    private void criarExames(){

        //TODO add paciente e medico
        String resultado = faker.medical().diseaseName();
        Tipo_Exame_Enum tipoExame = TipoExameGenerator.generate();
        Date dataExame  = faker.date().past(90, TimeUnit.DAYS);

    }
    private void criarAtestados(){
        //TODO add exame
        RiscoOcupacionaEnum riscoOcupacional = RiscoOcupacionalGenerator.generate();

}

}
