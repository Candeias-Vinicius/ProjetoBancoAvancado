package br.com.android.projetobancoavancado.clinica.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private final static String name = "bancoclinica_db";

    private final static int version = 1;

    public DBHelper(@Nullable Context context) {
        super(context, name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS pacientes (id integer PRIMARY KEY AUTOINCREMENT," +
                "cpf varchar(11), nome varchar(255), FOREIGN KEY(empresa_id) REFERENCES empresa(id), FOREIGN KEY(cargo_id) REFERENCES cargo(id))");

        db.execSQL("CREATE TABLE IF NOT EXISTS medicos (id integer PRIMARY KEY AUTOINCREMENT," +
                "crm varchar(12), nome varchar(255), email varchar(255), especialidade varchar(255))");

        db.execSQL("CREATE TABLE IF NOT EXISTS cargos (id integer PRIMARY KEY AUTOINCREMENT," +
                "nome varchar(11))");

        db.execSQL("CREATE TABLE IF NOT EXISTS empresas (id integer PRIMARY KEY AUTOINCREMENT," +
                "cnpj varchar(11), nome varchar(255), segmento varchar(255))");

        db.execSQL("CREATE TABLE IF NOT EXISTS exames (id integer PRIMARY KEY AUTOINCREMENT," +
                "resultado varchar(11), tipo_exame varchar(255), data DATE, FOREIGN KEY(medico_id) REFERENCES medico(id), FOREIGN KEY(paciente_id) REFERENCES paciente(id))");

        db.execSQL("CREATE TABLE IF NOT EXISTS atestados (id integer PRIMARY KEY AUTOINCREMENT," +
                "risco_ocupacional varchar(255), FOREIGN KEY(exame_id) REFERENCES exame(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE prontuarios");
        onCreate(db);
    }
}
