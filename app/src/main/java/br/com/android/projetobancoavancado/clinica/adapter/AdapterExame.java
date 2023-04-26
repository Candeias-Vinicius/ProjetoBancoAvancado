package br.com.android.projetobancoavancado.clinica.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.android.projetobancoavancado.R;
import br.com.android.projetobancoavancado.clinica.model.Exame;

public class AdapterExame extends RecyclerView.Adapter<AdapterExame.MyViewHolder>{
    private final List<Exame> exames;

    public AdapterExame(List<Exame> exames) {
        this.exames = exames;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_exame, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Exame exame = exames.get(position);
        holder.nome.setText(exame.getPaciente().getNome());
        holder.cpf.setText(exame.getPaciente().getCpf());
        holder.medico.setText(exame.getMedico().getNome());
        holder.crm.setText(exame.getMedico().getCrm());
        holder.resultado.setText(exame.getResultado());
        holder.tipoExame.setText(exame.getTipo_exame().getNome());
        holder.data.setText(exame.getData().toString());
    }

    @Override
    public int getItemCount() {
        return exames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView cpf;

        TextView medico;

        TextView crm;

        TextView resultado;

        TextView tipoExame;

        TextView data;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.NomePacienteExame);
            cpf = itemView.findViewById(R.id.CpfPacienteExame);
            medico = itemView.findViewById(R.id.NomeMedicoExame);
            crm = itemView.findViewById(R.id.CrmMedicoExame);
            resultado = itemView.findViewById(R.id.ResultadoExame);
            tipoExame = itemView.findViewById(R.id.TipoExame);
            data = itemView.findViewById(R.id.DataExame);

        }
    }
}
