package br.com.android.projetobancoavancado.clinica.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.util.List;

import br.com.android.projetobancoavancado.R;
import br.com.android.projetobancoavancado.clinica.adapter.AdapterExame;
import br.com.android.projetobancoavancado.clinica.dao.ExameDAO;
import br.com.android.projetobancoavancado.clinica.model.Exame;

public class ExameFragment extends Fragment {
    private RecyclerView recyclerView;

    public ExameFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);
        AdapterExame adapter = new AdapterExame(list());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;
    }
    public List<Exame> list() {

        ExameDAO dataBase = new ExameDAO(getActivity());

        try {
            return dataBase.listarTodos();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
