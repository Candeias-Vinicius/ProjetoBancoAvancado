package br.com.android.projetobancoavancado.clinica.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.android.projetobancoavancado.R;
import br.com.android.projetobancoavancado.clinica.model.EmpresaRiscoOcupacional;

public class AdapterRiscoOcupacional extends RecyclerView.Adapter<AdapterRiscoOcupacional.MyViewHolder>{
    private final List<EmpresaRiscoOcupacional> riscosOcupacionais;

    public AdapterRiscoOcupacional(List<EmpresaRiscoOcupacional> riscosOcupacionais) {
        this.riscosOcupacionais = riscosOcupacionais;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_risco_ocupacional, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        EmpresaRiscoOcupacional riscoOcupacional = riscosOcupacionais.get(position);

        holder.nome.setText(riscoOcupacional.getRiscoOcupacional().getNomeRisco());
        holder.quantidade.setText(String.valueOf(riscoOcupacional.getTotal()));
    }

    @Override
    public int getItemCount() {
        return riscosOcupacionais.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView quantidade;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.NomeRiscoOcupacional);
            quantidade = itemView.findViewById(R.id.QuantidadeRiscoOcupacional);

        }
    }
}
