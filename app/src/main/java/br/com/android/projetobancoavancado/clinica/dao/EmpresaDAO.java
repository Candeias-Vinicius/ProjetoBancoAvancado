package br.com.android.projetobancoavancado.clinica.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import br.com.android.projetobancoavancado.clinica.enums.SegmentoEnum;
import br.com.android.projetobancoavancado.clinica.model.Empresa;
import br.com.android.projetobancoavancado.clinica.util.DBHelper;

public class EmpresaDAO {
    private DBHelper dbHelper;

    private SQLiteDatabase dataBase;

    public EmpresaDAO(Context context) {
        dbHelper = new DBHelper(context);
        dataBase = dbHelper.getWritableDatabase();
    }

    public void inserir(Empresa empresa){

        ContentValues values = new ContentValues();

        values.put("cnpj", empresa.getCnpj());
        values.put("nome", empresa.getNome());
        values.put("especialidade", empresa.getSegmento().getNome());

        dataBase.insert("Empresa",null,values);

    }

    public void listar(){

        List<Empresa> empresas = new ArrayList<Empresa>();

        String sql = "SELECT * FROM Empresa";

        Cursor cursor = dataBase.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(0);
            String cnpj = cursor.getString(1);
            String nome = cursor.getString(2);
            String segmentoStr = cursor.getString(3);

            SegmentoEnum segmento = SegmentoEnum.valueOf(segmentoStr);

            Empresa empresa = new Empresa(id, cnpj, nome, segmento);

            empresas.add(empresa);
        }
    }

    public Empresa BuscarPorId(Integer id){

        Empresa empresa = new Empresa(null, null, null, null);

        String sql = "SELECT * FROM Empresa WHERE id = ?";

        Cursor cursor = dataBase.rawQuery(sql, null);

        while (cursor.moveToNext()) {

            int empresaId = cursor.getInt(0);
            String cnpj = cursor.getString(1);
            String nome = cursor.getString(2);
            String segmentoStr = cursor.getString(3);

            SegmentoEnum segmento = SegmentoEnum.valueOf(segmentoStr);

            empresa = new Empresa(empresaId, cnpj, nome, segmento);

        }
        return empresa;
    }
    public void deletar(Integer id){

        dataBase.delete("Empresa", "id = ?", new String[] { String.valueOf(id) });
    }
}
