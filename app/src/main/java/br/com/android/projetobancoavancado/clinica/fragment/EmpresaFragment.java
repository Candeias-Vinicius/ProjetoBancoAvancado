package br.com.android.projetobancoavancado.clinica.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.android.projetobancoavancado.R;
import br.com.android.projetobancoavancado.clinica.adapter.AdapterEmpresa;
import br.com.android.projetobancoavancado.clinica.dao.EmpresaDAO;
import br.com.android.projetobancoavancado.clinica.model.Atestado;
import br.com.android.projetobancoavancado.clinica.model.Empresa;

public class EmpresaFragment extends Fragment {
    private RecyclerView recyclerView;

    public EmpresaFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);
        AdapterEmpresa adapter = new AdapterEmpresa(list());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;
    }
    public List<Empresa> list()  {

        EmpresaDAO dataBase = new EmpresaDAO(getActivity());

            return dataBase.listarTodos();



    }
}
