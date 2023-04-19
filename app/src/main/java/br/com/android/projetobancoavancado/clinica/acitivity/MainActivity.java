package br.com.android.projetobancoavancado.clinica.acitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.android.projetobancoavancado.R;

public class MainActivity extends AppCompatActivity {

    private Button cadastrar;
    private Button listar;
    private Button popularBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cadastrar = findViewById(R.id.botaoCadastro);
        listar = findViewById(R.id.botaoListar);
        popularBanco = findViewById(R.id.botaoPopular);


    }

    public void mostrarTiposDeCadastro(View view){
        Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(intent);
    }

    public void mostrarTiposDeLista(View view){
        Intent intent = new Intent(MainActivity.this, ListarActivity.class);
        startActivity(intent);
    }

    public void popularBanco(View view){

    }
}