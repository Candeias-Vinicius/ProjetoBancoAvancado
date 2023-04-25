package br.com.android.projetobancoavancado.clinica.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import br.com.android.projetobancoavancado.clinica.enums.EspecialidadeEnum;
import br.com.android.projetobancoavancado.clinica.enums.RiscoOcupacionalEnum;
import br.com.android.projetobancoavancado.clinica.enums.SegmentoEnum;
import br.com.android.projetobancoavancado.clinica.enums.TipoExameEnum;
import br.com.android.projetobancoavancado.clinica.model.Atestado;
import br.com.android.projetobancoavancado.clinica.model.Cargo;
import br.com.android.projetobancoavancado.clinica.model.Empresa;
import br.com.android.projetobancoavancado.clinica.model.Exame;
import br.com.android.projetobancoavancado.clinica.model.Medico;
import br.com.android.projetobancoavancado.clinica.model.Paciente;
import br.com.android.projetobancoavancado.clinica.util.DBHelper;

public class AtestadoDAO {
    private DBHelper dbHelper;

    private SQLiteDatabase dataBase;

    public AtestadoDAO(Context context) {
        dbHelper = new DBHelper(context);
        dataBase = dbHelper.getWritableDatabase();
    }

    public void inserir(Atestado atestado){

        ContentValues values = new ContentValues();

        values.put("exame_id", atestado.getExame().getId());
        values.put("risco_ocupacional", atestado.getRiscoOcupacional().getNomeRisco());

        dataBase.insert("Atestado",null,values);

    }
    public List<Atestado> listarTodos() throws ParseException {

        List<Atestado> atestados = new ArrayList<Atestado>();

        String sql = "SELECT a.id, a.risco_ocupacional, " +
                "e.id AS exame_id, e.medico_id AS exame_medico_id, e.paciente_id AS exame_paciente_id, " +
                "e.resultado AS exame_resultado, e.tipo_exame AS exame_tipo_exame, e.data AS exame_data, " +
                "m.id AS medico_id, m.crm AS medico_crm, m.nome AS medico_nome, m.email AS medico_email, " +
                "m.especialidade AS medico_especialidade, p.id AS paciente_id, p.cpf AS paciente_cpf, " +
                "p.nome AS paciente_nome, emp.id AS empresa_id, emp.cnpj AS empresa_cnpj, " +
                "emp.nome AS empresa_nome, emp.segmento AS empresa_segmento, c.id AS cargo_id, " +
                "c.nome AS cargo_nome " +
                "FROM Atestado a " +
                "INNER JOIN Exame e ON a.exame_id = e.id " +
                "INNER JOIN Medico m ON e.medico_id = m.id " +
                "INNER JOIN Paciente p ON e.paciente_id = p.id " +
                "INNER JOIN Empresa emp ON p.empresa_id = emp.id " +
                "INNER JOIN Cargo c ON p.cargo_id = c.id";

        Cursor cursor = dataBase.rawQuery(sql, null);


        while (cursor.moveToNext()){

            int atestadoId = cursor.getInt(0);
            String riscoOcupacionalStr = cursor.getString(1);

            int exameId = cursor.getInt(2);
            int exameMedicoId = cursor.getInt(3);
            int examePacienteId = cursor.getInt(4);
            String resultado = cursor.getString(5);
            String tipoExameStr = cursor.getString(6);
            String dataStr = cursor.getString(7);
            int medicoId = cursor.getInt(8);
            String crm = cursor.getString(9);
            String medicoNome = cursor.getString(10);
            String email = cursor.getString(11);
            String especialidadeStr = cursor.getString(12);

            int pacienteId = cursor.getInt(13);
            String cpf = cursor.getString(14);
            String pacienteNome = cursor.getString(15);

            int empresaId = cursor.getInt(16);
            String cnpj = cursor.getString(17);
            String empresaNome = cursor.getString(18);
            String segmentoStr = cursor.getString(19);

            int cargoId = cursor.getInt(20);
            String cargoNome = cursor.getString(21);

            SegmentoEnum segmento = SegmentoEnum.valueOf(segmentoStr.toUpperCase());
            EspecialidadeEnum especialidade = EspecialidadeEnum.valueOf(especialidadeStr.toUpperCase());
            RiscoOcupacionalEnum riscoOcupacional = RiscoOcupacionalEnum.valueOf(riscoOcupacionalStr.toUpperCase());
            TipoExameEnum tipoExame = TipoExameEnum.valueOf(tipoExameStr.toUpperCase());

            SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            Date data = format.parse(dataStr);

            Cargo cargo = new Cargo(cargoId, cargoNome);
            Empresa empresa = new Empresa(empresaId, cnpj, empresaNome, segmento);
            Paciente paciente = new Paciente(pacienteId, cpf, pacienteNome, empresa, cargo);
            Medico medico = new Medico(medicoId, crm, medicoNome,email, especialidade);
            Exame exame = new Exame(exameId, medico, paciente, resultado, tipoExame, data);
            Atestado atestado = new Atestado(atestadoId, exame , riscoOcupacional);

            atestados.add(atestado);

        }
        return atestados;
    }

    public Atestado buscarAtestadoPorId(Integer id) throws ParseException {

        Atestado atestado = new Atestado(null, null, null);

        String sql = "SELECT a.id, a.risco_ocupacional, " +
                "e.id AS exame_id, e.medico_id AS exame_medico_id, e.paciente_id AS exame_paciente_id, " +
                "e.resultado AS exame_resultado, e.tipo_exame AS exame_tipo_exame, e.data AS exame_data, " +
                "m.id AS medico_id, m.crm AS medico_crm, m.nome AS medico_nome, m.email AS medico_email, " +
                "m.especialidade AS medico_especialidade, p.id AS paciente_id, p.cpf AS paciente_cpf, " +
                "p.nome AS paciente_nome, emp.id AS empresa_id, emp.cnpj AS empresa_cnpj, " +
                "emp.nome AS empresa_nome, emp.segmento AS empresa_segmento, c.id AS cargo_id, " +
                "c.nome AS cargo_nome " +
                "FROM Atestado a " +
                "INNER JOIN Exame e ON a.id_exame = e.id " +
                "INNER JOIN Medico m ON e.medico_id = m.id " +
                "INNER JOIN Paciente p ON e.paciente_id = p.id " +
                "INNER JOIN Empresa emp ON p.empresa_id = emp.id " +
                "INNER JOIN Cargo c ON p.cargo_id = c.id " +
                "WHERE a.id = ?";

        Cursor cursor = dataBase.rawQuery(sql, new String[]{String.valueOf(id)});

        while (cursor.moveToNext()) {

            int atestadoId = cursor.getInt(0);
            String riscoOcupacionalStr = cursor.getString(1);

            int exameId = cursor.getInt(2);
            int exameMedicoId = cursor.getInt(3);
            int examePacienteId = cursor.getInt(4);
            String resultado = cursor.getString(5);
            String tipoExameStr = cursor.getString(6);
            String dataStr = cursor.getString(7);
            int medicoId = cursor.getInt(8);
            String crm = cursor.getString(9);
            String medicoNome = cursor.getString(10);
            String email = cursor.getString(11);
            String especialidadeStr = cursor.getString(12);

            int pacienteId = cursor.getInt(13);
            String cpf = cursor.getString(14);
            String pacienteNome = cursor.getString(15);

            int empresaId = cursor.getInt(16);
            String cnpj = cursor.getString(17);
            String empresaNome = cursor.getString(18);
            String segmentoStr = cursor.getString(19);

            int cargoId = cursor.getInt(20);
            String cargoNome = cursor.getString(21);

            SegmentoEnum segmento = SegmentoEnum.valueOf(segmentoStr);
            EspecialidadeEnum especialidade = EspecialidadeEnum.valueOf(especialidadeStr);
            RiscoOcupacionalEnum riscoOcupacional = RiscoOcupacionalEnum.valueOf(riscoOcupacionalStr);
            TipoExameEnum tipoExame = TipoExameEnum.valueOf(tipoExameStr);

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date data = format.parse(dataStr);

            Cargo cargo = new Cargo(cargoId, cargoNome);
            Empresa empresa = new Empresa(empresaId, cnpj, empresaNome, segmento);
            Paciente paciente = new Paciente(pacienteId, cpf, pacienteNome, empresa, cargo);
            Medico medico = new Medico(medicoId, crm, medicoNome, email, especialidade);
            Exame exame = new Exame(exameId, medico, paciente, resultado, tipoExame, data);
            atestado = new Atestado(atestadoId, exame, riscoOcupacional);

        }
        return atestado;
    }
    public void deletar(Integer id){
        dataBase.delete("Atestado", "id = ?", new String[] { String.valueOf(id) });
    }
}
