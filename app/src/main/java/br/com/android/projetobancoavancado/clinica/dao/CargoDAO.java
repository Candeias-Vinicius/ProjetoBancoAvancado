package br.com.android.projetobancoavancado.clinica.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.android.projetobancoavancado.clinica.model.Cargo;
import br.com.android.projetobancoavancado.clinica.util.DBHelper;

public class CargoDAO {
    private DBHelper dbHelper;

    private SQLiteDatabase dataBase;

    public CargoDAO(Context context) {
        dbHelper = new DBHelper(context);
        dataBase = dbHelper.getWritableDatabase();
    }

    public void insert(Cargo cargo){

        ContentValues values = new ContentValues();

        values.put("nome", cargo.getNome());

        dataBase.insert("Cargo", null, values);


    }
    public List<Cargo> listarTodos(){

        List<Cargo> cargos = new ArrayList<Cargo>();

        String sql = "SELECT * FROM Cargo";

        Cursor cursor = dataBase.rawQuery(sql,null);

        while(cursor.moveToNext()){

            int id = cursor.getInt(0);
            String nome = cursor.getString(1);

            Cargo cargo = new Cargo(id, nome);

            cargos.add(cargo);
        }
        return cargos;
    }

    public Cargo buscaCargoPorId(Integer id) {

        Cargo cargo = new Cargo(null, null);

        String sql = "SELECT * FROM Cargo";

        Cursor cursor = dataBase.rawQuery(sql,null);

        while(cursor.moveToNext()){

            int cargoId = cursor.getInt(0);
            String nome = cursor.getString(1);

            cargo = new Cargo(id, nome);
        }

        return cargo;
    }
    public void deletar(Integer id){

        dataBase.delete("Cargo", "id = ?", new String[] { String.valueOf(id) });
    }
    public void deletarTabela(){
        dataBase.execSQL("DELETE FROM Cargo;");
    }
}
