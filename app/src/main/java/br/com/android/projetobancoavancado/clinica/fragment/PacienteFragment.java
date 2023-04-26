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
import br.com.android.projetobancoavancado.clinica.adapter.AdapterPaciente;
import br.com.android.projetobancoavancado.clinica.dao.PacienteDAO;
import br.com.android.projetobancoavancado.clinica.model.Paciente;

public class PacienteFragment extends Fragment {
    private RecyclerView recyclerView;

    public PacienteFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);
        AdapterPaciente adapter = new AdapterPaciente(list());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;
    }
    public List<Paciente> list()  {

        PacienteDAO dataBase = new PacienteDAO(getActivity());

        return dataBase.listarTodos();



    }
}
