package br.com.android.projetobancoavancado.clinica.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.android.projetobancoavancado.R;
import br.com.android.projetobancoavancado.clinica.model.Empresa;

public class AdapterEmpresa extends RecyclerView.Adapter<AdapterEmpresa.MyViewHolder> {
    private final List<Empresa> empresas;

    public AdapterEmpresa(List<Empresa> empresas) {
        this.empresas = empresas;

    }

    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_empresa, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Empresa empresa = empresas.get(position);

        holder.nome.setText(empresa.getNome());
        holder.cnpj.setText(empresa.getCnpj());
        holder.segmento.setText(empresa.getSegmento().getNome());
    }

    @Override
    public int getItemCount() {
        return empresas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;

        TextView cnpj;

        TextView segmento;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.NomeEmpresa);
            cnpj = itemView.findViewById(R.id.CnpjEmpresa);
            segmento = itemView.findViewById(R.id.SegmentoEmpresa);

        }
    }
}
