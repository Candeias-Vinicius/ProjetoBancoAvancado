package br.com.android.projetobancoavancado.clinica.dbEnrichment.generator;

import java.util.Random;

import br.com.android.projetobancoavancado.clinica.model.Cargo;
import br.com.android.projetobancoavancado.clinica.model.Empresa;
import br.com.android.projetobancoavancado.clinica.model.Paciente;

public class PacienteGenerator {
    private static final Random random = new Random();

    public static Paciente generate(int numPacientes, int numEmpresas, int numCargos){
        int id = random.nextInt(numPacientes + 1);
        Empresa empresa = EmpresaGenerator.generate(numEmpresas);
        Cargo cargo = CargoGenerator.generate(numCargos);
        Paciente paciente = new Paciente(id, "", "", empresa, cargo);
        return paciente;
    }
}
