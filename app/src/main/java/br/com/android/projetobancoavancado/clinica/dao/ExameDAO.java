package br.com.android.projetobancoavancado.clinica.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.android.projetobancoavancado.clinica.enums.TipoExameEnum;
import br.com.android.projetobancoavancado.clinica.model.Exame;
import br.com.android.projetobancoavancado.clinica.util.DBHelper;

public class ExameDAO {

    private DBHelper dbHelper;

    private SQLiteDatabase dataBase;

    public ExameDAO(Context context) {
        dbHelper = new DBHelper(context);
        dataBase = dbHelper.getWritableDatabase();
    }

    public void inserir(Exame exame){

        ContentValues values = new ContentValues();

        values.put("medico_id", exame.getMedico().getId());
        values.put("paciente_id", exame.getPaciente().getId());
        values.put("tipo_exame", exame.getTipo_exame().getNome());
        values.put("data", exame.getData().toString());

        dataBase.insert("Exame",null,values);

    }

    public List<Exame> buscarExames(){

        List<Exame> exames = new ArrayList<Exame>();

        String sql = "SELECT e.id, m.id AS medico_id, m.crm, m.nome AS medico_nome, " +
                "p.id AS paciente_id, p.cpf, p.nome AS paciente_nome, " +
                "e.tipo, e.data " +
                "FROM Exame e " +
                "JOIN Medico m ON e.medico_id = m.id " +
                "JOIN Paciente p ON e.paciente_id = p.id";

        Cursor cursor = dataBase.rawQuery(sql, null);


        return exames;
    }

}
