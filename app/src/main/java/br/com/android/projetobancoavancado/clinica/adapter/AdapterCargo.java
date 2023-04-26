package br.com.android.projetobancoavancado.clinica.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.android.projetobancoavancado.R;
import br.com.android.projetobancoavancado.clinica.model.Cargo;

public class AdapterCargo extends RecyclerView.Adapter<AdapterCargo.MyViewHolder>{
    private final List<Cargo> cargos;

    public AdapterCargo(List<Cargo> cargos) {
        this.cargos = cargos;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_cargo, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Cargo cargo = cargos.get(position);

        holder.nome.setText(cargo.getNome());

    }

    @Override
    public int getItemCount() {
        return cargos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.NomeCargo);

        }
    }
}
