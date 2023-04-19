package br.com.android.projetobancoavancado.clinica.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import br.com.android.projetobancoavancado.clinica.enums.SegmentoEnum;
import br.com.android.projetobancoavancado.clinica.model.Cargo;
import br.com.android.projetobancoavancado.clinica.model.Empresa;
import br.com.android.projetobancoavancado.clinica.model.Paciente;
import br.com.android.projetobancoavancado.clinica.util.DBHelper;

public class PacienteDAO {

    private DBHelper dbHelper;

    private SQLiteDatabase dataBase;

    public PacienteDAO(Context context) {
        dbHelper = new DBHelper(context);
        dataBase = dbHelper.getWritableDatabase();
    }

    public void inserir(Paciente paciente){

        ContentValues values = new ContentValues();

        values.put("nome", paciente.getNome());
        values.put("cpf", paciente.getCpf());
        values.put("empresa_id", paciente.getEmpresa().getId());
        values.put("cargo_id", paciente.getCargo().getId());

        dataBase.insert("Paciente",null,values);

    }

    public List<Paciente> listarTodos(){

        List<Paciente> pacientes = new ArrayList<Paciente>();

        String sql = "SELECT p.id, p.cpf, p.nome, c.id AS cargo_id, c.nome AS cargo_nome, " +
                "e.id AS empresa_id, e.cnpj, e.nome AS empresa_nome, e.segmento " +
                "FROM Paciente p " +
                "JOIN Cargo c ON p.cargo_id = c.id " +
                "JOIN Empresa e ON p.empresa_id = e.id";

        Cursor cursor = dataBase.rawQuery(sql, null);

        while (cursor.moveToNext()){

            int id = cursor.getInt(0);
            String cpf = cursor.getString(1);
            String nome = cursor.getString(2);
            int cargoId = cursor.getInt(3);
            String cargoNome = cursor.getString(4);
            int empresaId = cursor.getInt(5);
            String cnpj = cursor.getString(6);
            String empresaNome = cursor.getString(7);
            String segmentoStr = cursor.getString(8);


            SegmentoEnum segmento = SegmentoEnum.valueOf(segmentoStr);

            Cargo cargo = new Cargo(cargoId, cargoNome);
            Empresa empresa = new Empresa(empresaId, cnpj, empresaNome, segmento);
            Paciente paciente = new Paciente(id, cpf, nome, empresa, cargo);

            pacientes.add(paciente);

        }
        return pacientes;
    }

    public Paciente buscarPorId(Integer id) {

        Paciente paciente = new Paciente(null, null, null, null, null);

        String sql = "SELECT p.id, p.cpf, p.nome, c.id AS cargo_id, c.nome AS cargo_nome, " +
                "e.id AS empresa_id, e.cnpj, e.nome AS empresa_nome, e.segmento " +
                "FROM Paciente p " +
                "JOIN Cargo c ON p.cargo_id = c.id " +
                "JOIN Empresa e ON p.empresa_id = e.id " +
                "WHERE p.id = ?";


        Cursor cursor = dataBase.rawQuery(sql, new String[]{String.valueOf(id)});

        while (cursor.moveToNext()) {

            int pacienteId = cursor.getInt(0);
            String cpf = cursor.getString(1);
            String nome = cursor.getString(2);
            int cargoId = cursor.getInt(3);
            String cargoNome = cursor.getString(4);
            int empresaId = cursor.getInt(5);
            String cnpj = cursor.getString(6);
            String empresaNome = cursor.getString(7);
            String segmentoStr = cursor.getString(8);


            SegmentoEnum segmento = SegmentoEnum.valueOf(segmentoStr);

            Cargo cargo = new Cargo(cargoId, cargoNome);
            Empresa empresa = new Empresa(empresaId, cnpj, empresaNome, segmento);
            paciente = new Paciente(pacienteId, cpf, nome, empresa, cargo);


        }
        return paciente;
    }
    public void deletar(Integer id){

        dataBase.delete("Paciente", "id = ?", new String[] { String.valueOf(id) });
    }
}
