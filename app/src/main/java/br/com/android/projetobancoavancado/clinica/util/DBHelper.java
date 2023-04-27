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

        db.execSQL("CREATE TABLE IF NOT EXISTS Paciente (id integer PRIMARY KEY AUTOINCREMENT," +
                "cpf varchar(11), nome varchar(255), empresa_id integer, cargo_id integer, FOREIGN KEY(empresa_id) REFERENCES Empresa(id), FOREIGN KEY(cargo_id) REFERENCES Cargo(id))");

        db.execSQL("CREATE TABLE IF NOT EXISTS Medico (id integer PRIMARY KEY AUTOINCREMENT," +
                "crm varchar(12), nome varchar(255), email varchar(255), especialidade varchar(255))");

        db.execSQL("CREATE TABLE IF NOT EXISTS Cargo (id integer PRIMARY KEY AUTOINCREMENT," +
                "nome varchar(11))");

        db.execSQL("CREATE TABLE IF NOT EXISTS Empresa (id integer PRIMARY KEY AUTOINCREMENT," +
                "cnpj varchar(11), nome varchar(255), segmento varchar(255))");

        db.execSQL("CREATE TABLE IF NOT EXISTS Exame (id integer PRIMARY KEY AUTOINCREMENT," +
                "resultado varchar(11), tipo_exame varchar(255), data DATE, medico_id integer, paciente_id integer,FOREIGN KEY(medico_id) REFERENCES Medico(id), FOREIGN KEY(paciente_id) REFERENCES Paciente(id))");

        db.execSQL("CREATE TABLE IF NOT EXISTS Atestado (id integer PRIMARY KEY AUTOINCREMENT," +
                "risco_ocupacional varchar(255), exame_id integer, FOREIGN KEY(exame_id) REFERENCES Exame(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    }
}
