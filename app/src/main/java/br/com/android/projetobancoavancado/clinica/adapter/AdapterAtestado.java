package br.com.android.projetobancoavancado.clinica.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.android.projetobancoavancado.R;
import br.com.android.projetobancoavancado.clinica.model.Atestado;

public class AdapterAtestado extends RecyclerView.Adapter<AdapterAtestado.MyViewHolder>{
    private final List<Atestado> atestados;

    public AdapterAtestado(List<Atestado> atestados) {
        this.atestados = atestados;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_atestado, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Atestado atestado = atestados.get(position);

        holder.nome.setText(atestado.getExame().getPaciente().getNome());
        holder.cpf.setText(atestado.getExame().getPaciente().getCpf());
        holder.medico.setText(atestado.getExame().getMedico().getNome());
        holder.crm.setText(atestado.getExame().getMedico().getCrm());
        holder.resultado.setText(atestado.getExame().getResultado());
        holder.cargo.setText(atestado.getExame().getPaciente().getCargo().getNome());
        holder.empresa.setText(atestado.getExame().getPaciente().getEmpresa().getNome());
        holder.riscoOcupacional.setText(atestado.getRiscoOcupacional().getNomeRisco());
    }

    @Override
    public int getItemCount() {
        return atestados.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView cpf;

        TextView medico;

        TextView crm;

        TextView resultado;

        TextView cargo;

        TextView empresa;

        TextView riscoOcupacional;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.textNome);
            cpf = itemView.findViewById(R.id.textCpf);
            medico = itemView.findViewById(R.id.textNomeMedico);
            crm = itemView.findViewById(R.id.textCrmMedico);
            resultado = itemView.findViewById(R.id.textResultadoExame);
            cargo = itemView.findViewById(R.id.textCargo);
            empresa = itemView.findViewById(R.id.textEmpresa);
            riscoOcupacional = itemView.findViewById(R.id.textRiscoOcupacional);
        }
    }
}
