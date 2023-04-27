package br.com.android.projetobancoavancado.clinica.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import br.com.android.projetobancoavancado.R;
import br.com.android.projetobancoavancado.clinica.fragment.AtestadoFragment;
import br.com.android.projetobancoavancado.clinica.fragment.CargoFragment;
import br.com.android.projetobancoavancado.clinica.fragment.EmpresaFragment;
import br.com.android.projetobancoavancado.clinica.fragment.ExameFragment;
import br.com.android.projetobancoavancado.clinica.fragment.MedicoFragment;
import br.com.android.projetobancoavancado.clinica.fragment.PacienteFragment;
import br.com.android.projetobancoavancado.clinica.fragment.RiscoOcupacionalFragment;

public class ListarActivity extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listar);

        smartTabLayout = findViewById(R.id.viewPagerTab);
        viewPager = findViewById(R.id.viewPager);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Atestados", AtestadoFragment.class)
                .add("Cargos", CargoFragment.class)
                .add("Empresas", EmpresaFragment.class)
                .add("Exames", ExameFragment.class)
                .add("Medicos", MedicoFragment.class)
                .add("Pacientes", PacienteFragment.class)
                .add("Riscos Ocupacionais", RiscoOcupacionalFragment.class)
                .create());

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}