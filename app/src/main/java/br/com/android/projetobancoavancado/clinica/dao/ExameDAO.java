package br.com.android.projetobancoavancado.clinica.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import br.com.android.projetobancoavancado.clinica.enums.EspecialidadeEnum;
import br.com.android.projetobancoavancado.clinica.enums.SegmentoEnum;
import br.com.android.projetobancoavancado.clinica.enums.TipoExameEnum;
import br.com.android.projetobancoavancado.clinica.model.Cargo;
import br.com.android.projetobancoavancado.clinica.model.Empresa;
import br.com.android.projetobancoavancado.clinica.model.Exame;
import br.com.android.projetobancoavancado.clinica.model.Medico;
import br.com.android.projetobancoavancado.clinica.model.Paciente;
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
        values.put("resultado", exame.getResultado());
        values.put("data", exame.getData().toString());

        dataBase.insert("Exame",null,values);

    }

    public List<Exame> listarTodos() throws ParseException {

        List<Exame> exames = new ArrayList<Exame>();

        String sql = "SELECT e.id, e.tipo_exame, e.resultado, e.data, "+
                "p.id AS paciente_id, p.cpf, p.nome AS paciente_nome, "+
                "m.id AS medico_id, m.crm, m.nome AS medico_nome, m.email AS medico_email, m.especialidade AS medico_especialidade, "+
                "c.id AS cargo_id, c.nome AS cargo_nome, "+
                "em.id AS empresa_id, em.cnpj, em.nome AS empresa_nome, em.segmento "+
                "FROM Exame e "+
                "JOIN Paciente p ON e.paciente_id = p.id "+
                "JOIN Medico m ON e.medico_id = m.id "+
                "JOIN Cargo c ON p.cargo_id = c.id "+
                "JOIN Empresa em ON p.empresa_id = em.id ";

        Cursor cursor = dataBase.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String tipoExameStr = cursor.getString(1);
            String resultado = cursor.getString(2);
            String dataStr = cursor.getString(3);

            int pacienteId = cursor.getInt(4);
            String pacienteCpf = cursor.getString(5);
            String pacienteNome = cursor.getString(6);

            int medicoId = cursor.getInt(7);
            String medicoCnpj = cursor.getString(8);
            String medicoNome = cursor.getString(9);
            String medicoEmail = cursor.getString(10);
            String especialidadeStr = cursor.getString(11);

            int cargoId = cursor.getInt(12);
            String cargoNome = cursor.getString(13);

            int empresaId = cursor.getInt(14);
            String empresaCnpj = cursor.getString(15);
            String empresaNome = cursor.getString(16);
            String segmentoStr = cursor.getString(17);

            SegmentoEnum segmento = SegmentoEnum.valueOf(segmentoStr.toUpperCase());
            EspecialidadeEnum especialidade = EspecialidadeEnum.valueOf(especialidadeStr.toUpperCase());
            TipoExameEnum tipoExame = TipoExameEnum.valueOf(tipoExameStr.toUpperCase());
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            Date data = format.parse(dataStr);

            Cargo cargo = new Cargo(cargoId, cargoNome);
            Empresa empresa = new Empresa(empresaId, empresaCnpj, empresaNome, segmento);
            Paciente paciente = new Paciente(pacienteId, pacienteCpf, pacienteNome, empresa, cargo);
            Medico medico = new Medico(medicoId, medicoCnpj,medicoNome,medicoEmail,especialidade);
            Exame exame = new Exame(id, medico, paciente, resultado,tipoExame,data);
            exames.add(exame);
        }

        return exames;
    }

    public Exame buscarPorId(Integer id) throws ParseException {
        Exame exame = new Exame(null, null,null,null,null, null);

        String sql = "SELECT e.id, e.tipo_exame, e.resultado, e.data, "+
                "p.id AS paciente_id, p.cpf, p.nome AS paciente_nome, "+
                "m.id AS medico_id, m.cnpj, m.nome AS medico_nome, m.email AS medico_email, m.especialidade AS medico_especialidade, "+
                "c.id AS cargo_id, c.nome AS cargo_nome, "+
                "em.id AS empresa_id, em.cnpj, em.nome AS empresa_nome, em.segmento "+
                "FROM Exame e "+
                "JOIN Paciente p ON e.paciente_id = p.id "+
                "JOIN Medico m ON e.medico_id = m.id "+
                "JOIN Cargo c ON p.cargo_id = c.id "+
                "JOIN Empresa em ON p.empresa_id = em.id " +
                "WHERE e.id = ?";

        Cursor cursor = dataBase.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int exameId = cursor.getInt(0);
            String tipoExameStr = cursor.getString(1);
            String resultado = cursor.getString(2);
            String dataStr = cursor.getString(3);

            int pacienteId = cursor.getInt(4);
            String pacienteCpf = cursor.getString(5);
            String pacienteNome = cursor.getString(6);

            int medicoId = cursor.getInt(7);
            String medicoCnpj = cursor.getString(8);
            String medicoNome = cursor.getString(9);
            String medicoEmail = cursor.getString(10);
            String especialidadeStr = cursor.getString(11);

            int cargoId = cursor.getInt(12);
            String cargoNome = cursor.getString(13);

            int empresaId = cursor.getInt(14);
            String empresaCnpj = cursor.getString(15);
            String empresaNome = cursor.getString(16);
            String segmentoStr = cursor.getString(17);

            SegmentoEnum segmento = SegmentoEnum.valueOf(segmentoStr.toUpperCase());
            EspecialidadeEnum especialidade = EspecialidadeEnum.valueOf(especialidadeStr.toUpperCase());
            TipoExameEnum tipoExame = TipoExameEnum.valueOf(tipoExameStr.toUpperCase());
            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            Date data = format.parse(dataStr);

            Cargo cargo = new Cargo(cargoId, cargoNome);
            Empresa empresa = new Empresa(empresaId, empresaCnpj, empresaNome, segmento);
            Paciente paciente = new Paciente(pacienteId, pacienteCpf, pacienteNome, empresa, cargo);
            Medico medico = new Medico(medicoId, medicoCnpj,medicoNome,medicoEmail,especialidade);
            exame = new Exame(exameId, medico, paciente, resultado,tipoExame,data);

        }
        return exame;
    }

    public void deletar(Integer id){
        dataBase.delete("Exame", "id = ?", new String[] { String.valueOf(id) });
    }
    public void deletarTabela(){
        dataBase.execSQL("DELETE FROM Exame;");
    }
}
