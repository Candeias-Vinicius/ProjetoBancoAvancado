package br.com.android.projetobancoavancado.clinica.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Banco extends SQLiteOpenHelper {


    public Banco(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql =
                "CREATE TABLE IF NOT EXISTS Atestado (" +
                "id integer PRIMARY KEY AUTOINCREMENT,"+
                "id_exame integer,"+
                "id_cargo_risco integer,"+
                "FOREIGN KEY (id_cargo_risco) REFERENCES Cargo_risco (id),"+
                "FOREIGN KEY (id_exame) REFERENCES Exame (id));"+

                "CREATE TABLE IF NOT EXISTS Cargo (" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "descricao VARCHAR (50) NOT NULL);"+

                "CREATE TABLE IF NOT EXISTS Cargo_risco ("+
                "id integer PRIMARY KEY AUTOINCREMENT,"+
                "id_cargo integer,"+
                "id_risco integer,"+
                "FOREIGN KEY (id_cargo) REFERENCES Cargo (id),"+
                "FOREIGN KEY (id_risco) REFERENCES Risco_ocupacional (id));"+

                "CREATE TABLE IF NOT EXISTS Empresa (" +
                "id int PRIMARY KEY, " +
                "nome_empresa VARCHAR(50) NOT NULL ," +
                " cnpj VARCHAR (50 ) NOT NULL," +
                " segmento VARCHAR(50) NOT NULL );"+

                "CREATE TABLE IF NOT EXISTS Exame (" +
                "id integer PRIMARY KEY AUTOINCREMENT," +
                "resultado VARCHAR (50) NOT NULL," +
                "data_exame DATE(50) NOT NULL,"  +
                " id_paciente integer REFERENCES Paciente ( id)" +
                " id_medico integer REFERENCES Medico ( id) , \"id_Tipo_exame\" INTEGER NULL);"+

                "CREATE TABLE IF NOT EXISTS Medico (" +
                "id INTEGER NULL," +
                "CRM VARCHAR(50) NULL DEFAULT NULL," +
                "Nome VARCHAR(50) NULL DEFAULT NULL," +
                "Email VARCHAR(50) NULL DEFAULT NULL" +
                ");"+

                 "CREATE TABLE IF NOT EXISTS Paciente (" +
                        "id integer PRIMARY KEY AUTOINCREMENT," +
                        "nome_paciente VARCHAR(50) NOT NULL , " +
                        "cpf VARCHAR (50) NOT NULL, " +
                        "cargo VARCHAR(50) NOT NULL, " +
                        " id_empresa integer REFERENCES Empresa ( id)" +
                        " );";




    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}


