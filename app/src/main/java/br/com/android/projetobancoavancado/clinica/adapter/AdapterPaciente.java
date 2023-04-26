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
import br.com.android.projetobancoavancado.clinica.model.Paciente;

public class AdapterPaciente extends RecyclerView.Adapter<AdapterPaciente.MyViewHolder>{
    private final List<Paciente> pacientes;

    public AdapterPaciente(List<Paciente> pacientes) {
        this.pacientes = pacientes;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_paciente, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Paciente paciente = pacientes.get(position);

        holder.nome.setText(paciente.getNome());
        holder.cpf.setText(paciente.getCpf());
        holder.empresa.setText(paciente.getEmpresa().getNome());
        holder.cargo.setText(paciente.getCargo().getNome());
    }

    @Override
    public int getItemCount() {
        return pacientes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;

        TextView cpf;

        TextView empresa;

        TextView cargo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.NomePaciente);
            cpf = itemView.findViewById(R.id.CpfPaciente);
            empresa = itemView.findViewById(R.id.EmpresaPaciente);
            cargo = itemView.findViewById(R.id.CargoPaciente);

        }
    }
}

