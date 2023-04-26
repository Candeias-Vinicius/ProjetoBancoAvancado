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
import br.com.android.projetobancoavancado.clinica.adapter.AdapterCargo;
import br.com.android.projetobancoavancado.clinica.dao.CargoDAO;
import br.com.android.projetobancoavancado.clinica.model.Atestado;
import br.com.android.projetobancoavancado.clinica.model.Cargo;

public class CargoFragment extends Fragment {
    private RecyclerView recyclerView;

    public CargoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);
        AdapterCargo adapter = new AdapterCargo(list());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;
    }
    public List<Cargo> list()  {

        CargoDAO dataBase = new CargoDAO(getActivity());

            return dataBase.listarTodos();

    }
}
