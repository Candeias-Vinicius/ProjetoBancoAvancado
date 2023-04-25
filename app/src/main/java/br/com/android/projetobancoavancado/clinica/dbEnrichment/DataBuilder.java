package br.com.android.projetobancoavancado.clinica.dbEnrichment;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.CNPJGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.CPFGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.CRMGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.CargoGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.EmpresaGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.EspecialidadeGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.ExameGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.MedicoGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.PacienteGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.RiscoOcupacionalGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.SegmentoGenerator;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.generator.TipoExameGenerator;
import br.com.android.projetobancoavancado.clinica.enums.EspecialidadeEnum;
import br.com.android.projetobancoavancado.clinica.enums.RiscoOcupacionalEnum;
import br.com.android.projetobancoavancado.clinica.enums.SegmentoEnum;
import br.com.android.projetobancoavancado.clinica.enums.TipoExameEnum;
import br.com.android.projetobancoavancado.clinica.model.Atestado;
import br.com.android.projetobancoavancado.clinica.model.Cargo;
import br.com.android.projetobancoavancado.clinica.model.Empresa;
import br.com.android.projetobancoavancado.clinica.model.Exame;
import br.com.android.projetobancoavancado.clinica.model.Medico;
import br.com.android.projetobancoavancado.clinica.model.Paciente;

public class DataBuilder {
    private final Faker faker = new Faker();
    public Empresa criarEmpresa() {

        String cnpj = CNPJGenerator.generate();
        String nome = faker.company().name();
        SegmentoEnum segmento = SegmentoGenerator.generate();

        Empresa empresa = new Empresa(cnpj, nome, segmento);
        return empresa;
    }

    public Cargo criarCargo() {

        String nome = faker.company().profession();
        Cargo cargo = new Cargo(nome);
        return cargo;
    }

    public Paciente criarPaciente(int numEmpresas, int numCargos) {

        String nome = faker.name().fullName();
        String cpf = CPFGenerator.generate();
        Empresa empresa = EmpresaGenerator.generate(numEmpresas);
        Cargo cargo = CargoGenerator.generate(numCargos);

        Paciente paciente = new Paciente(cpf, nome, empresa, cargo);
        return paciente;
    }

    public Medico criarMedico() {

        String crm = CRMGenerator.generate();
        String nome = faker.name().fullName();
        String email = faker.internet().emailAddress();
        EspecialidadeEnum especialidade = EspecialidadeGenerator.generate();
        Medico medico = new Medico(crm, nome, email, especialidade);
        return medico;

    }

    public Exame criarExame(int numPacientes, int numMedicos, int numEmpresas, int numCargos) {

        Paciente paciente = PacienteGenerator.generate(numPacientes,numEmpresas,numCargos);
        Medico medico = MedicoGenerator.generate(numMedicos);
        String resultado = faker.medical().diseaseName();
        TipoExameEnum tipoExame = TipoExameGenerator.generate();
        Date dataExame = faker.date().past(90, TimeUnit.DAYS);

        Exame exame = new Exame(medico, paciente, resultado, tipoExame, dataExame);
        return  exame;

    }

    public Atestado criarAtestado(int numExames, int numPacientes, int numEmpresas, int numCargos, int numMedicos) {

        Exame exame = ExameGenerator.generate(numExames, numPacientes, numEmpresas, numCargos, numMedicos);
        RiscoOcupacionalEnum riscoOcupacional = RiscoOcupacionalGenerator.generate();
        Atestado atestado = new Atestado(exame, riscoOcupacional);
        return atestado;

    }

}
