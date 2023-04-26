package br.com.android.projetobancoavancado.clinica.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.android.projetobancoavancado.R;
import br.com.android.projetobancoavancado.clinica.model.Medico;

public class AdapterMedico extends RecyclerView.Adapter<AdapterMedico.MyViewHolder>{
    private final List<Medico> medicos;

    public AdapterMedico(List<Medico> medicos) {
        this.medicos = medicos;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_medico, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Medico medico = medicos.get(position);

        holder.nome.setText(medico.getNome());
        holder.crm.setText(medico.getCrm());
        holder.email.setText(medico.getEmail());
        holder.especialidade.setText(medico.getEspecialidade().getNome());
    }

    @Override
    public int getItemCount() {
        return medicos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;

        TextView crm;

        TextView email;

        TextView especialidade;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.NomeMedico);
            crm = itemView.findViewById(R.id.CrmMedico);
            email = itemView.findViewById(R.id.EmailMedico);
            especialidade = itemView.findViewById(R.id.EspecialidadeMedico);

        }
    }
}
