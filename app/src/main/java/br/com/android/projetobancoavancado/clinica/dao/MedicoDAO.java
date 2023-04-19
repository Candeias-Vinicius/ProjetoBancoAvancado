package br.com.android.projetobancoavancado.clinica.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.android.projetobancoavancado.clinica.enums.EspecialidadeEnum;
import br.com.android.projetobancoavancado.clinica.model.Medico;
import br.com.android.projetobancoavancado.clinica.util.DBHelper;

public class MedicoDAO {

    private DBHelper dbHelper;

    private SQLiteDatabase dataBase;

    public MedicoDAO(Context context) {
        dbHelper = new DBHelper(context);
        dataBase = dbHelper.getWritableDatabase();
    }

    public void inserir(Medico medico){

        ContentValues values = new ContentValues();

        values.put("crm", medico.getCrm());
        values.put("nome", medico.getNome());
        values.put("email", medico.getEmail());
        values.put("especialidade", medico.getEspecialidade().getNome());

        dataBase.insert("Medico",null,values);

    }

    public void listar(){

        List<Medico> medicos = new ArrayList<Medico>();

        String sql = "SELECT * FROM Medico";

        Cursor cursor = dataBase.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String crm = cursor.getString(1);
            String nome = cursor.getString(2);
            String email = cursor.getString(3);
            String especialidadeStr = cursor.getString(4);

            EspecialidadeEnum especialidade = EspecialidadeEnum.valueOf(especialidadeStr);

            Medico medico = new Medico(id, crm, nome, email, especialidade);

            medicos.add(medico);
        }
    }

    public void deletar(Medico medico){

        dataBase.delete("medico", "id = ?", new String[] { String.valueOf(medico.getId()) });
    }
}
