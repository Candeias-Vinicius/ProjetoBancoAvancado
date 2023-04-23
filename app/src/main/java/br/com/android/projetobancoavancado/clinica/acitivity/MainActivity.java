package br.com.android.projetobancoavancado.clinica.acitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.android.projetobancoavancado.R;
import br.com.android.projetobancoavancado.clinica.dao.AtestadoDAO;
import br.com.android.projetobancoavancado.clinica.dao.CargoDAO;
import br.com.android.projetobancoavancado.clinica.dao.EmpresaDAO;
import br.com.android.projetobancoavancado.clinica.dao.ExameDAO;
import br.com.android.projetobancoavancado.clinica.dao.MedicoDAO;
import br.com.android.projetobancoavancado.clinica.dao.PacienteDAO;
import br.com.android.projetobancoavancado.clinica.dbEnrichment.DataBuilder;

public class MainActivity extends AppCompatActivity {
    private final EmpresaDAO empresaDAO = new EmpresaDAO(MainActivity.this);
    private final CargoDAO cargoDAO = new CargoDAO(MainActivity.this);
    private final PacienteDAO pacienteDAO = new PacienteDAO(MainActivity.this);
    private final MedicoDAO medicoDAO = new MedicoDAO(MainActivity.this);
    private final ExameDAO exameDAO = new ExameDAO(MainActivity.this);
    private final AtestadoDAO atestadoDAO = new AtestadoDAO(MainActivity.this);
    private final DataBuilder dataBuilder = new DataBuilder();
    private static final int NUM_EMPRESAS = 20;
    private static final int NUM_PACIENTES = 100;
    private static final int NUM_MEDICOS = 10;
    private static final int NUM_CARGOS = 20;
    private static final int NUM_EXAMES = 100;
    private static final int NUM_ATESTADOS = 50;

    private static final int MAX_TENTATIVAS = 5;


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

    public void mostrarTiposDeCadastro(View view) {
        Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
        startActivity(intent);
    }

    public void mostrarTiposDeLista(View view) {
        Intent intent = new Intent(MainActivity.this, ListarActivity.class);
        startActivity(intent);
    }

    public void popularBanco(View view){
        try {
            int tentativa = 0;

            for (int i = 0; i <= NUM_EMPRESAS; i++) {
                try {
                    empresaDAO.inserir(dataBuilder.criarEmpresa());
                } catch (Exception e) {
                    tentativa++;
                    if (tentativa <= MAX_TENTATIVAS) {
                        System.out.println("Erro ao inserir dado na base, tentando novamente. Tentativa " + tentativa + " de " + MAX_TENTATIVAS);
                        i--;
                    } else {
                        throw new Exception("Número máximo de " + MAX_TENTATIVAS + " tentativas excedido ao tentar popular banco");
                    }
                }
            }

            tentativa = 0;
            for (int i = 0; i <= NUM_CARGOS; i++) {
                try {
                    cargoDAO.insert(dataBuilder.criarCargo());
                } catch (Exception e) {
                    tentativa++;
                    if (tentativa <= MAX_TENTATIVAS) {
                        System.out.println("Erro ao inserir dado na base, tentando novamente. Tentativa " + tentativa + " de " + MAX_TENTATIVAS);
                        i--;
                    } else {
                        throw new Exception("Número máximo de " + MAX_TENTATIVAS + " tentativas excedido ao tentar popular banco");
                    }

                }
            }

            tentativa = 0;
            for (int i = 0; i <= NUM_PACIENTES; i++) {
                try {
                    pacienteDAO.inserir(dataBuilder.criarPaciente(NUM_EMPRESAS, NUM_CARGOS));

                } catch (Exception e) {
                    tentativa++;
                    if (tentativa <= MAX_TENTATIVAS) {
                        System.out.println("Erro ao inserir dado na base, tentando novamente. Tentativa " + tentativa + " de " + MAX_TENTATIVAS);
                        i--;
                    } else {
                        throw new Exception("Número máximo de " + MAX_TENTATIVAS + " tentativas excedido ao tentar popular banco");
                    }
                }
            }

            tentativa = 0;
            for (int i = 0; i <= NUM_MEDICOS; i++) {
                try {
                    medicoDAO.inserir(dataBuilder.criarMedico());

                } catch (Exception e) {
                    tentativa++;
                    if (tentativa <= MAX_TENTATIVAS) {
                        System.out.println("Erro ao inserir dado na base, tentando novamente. Tentativa " + tentativa + " de " + MAX_TENTATIVAS);
                        i--;
                    } else {
                        throw new Exception("Número máximo de " + MAX_TENTATIVAS + " tentativas excedido ao tentar popular banco");
                    }
                }
            }

            tentativa = 0;
            for (int i = 0; i <= NUM_EXAMES; i++) {
                try {
                    exameDAO.inserir(dataBuilder.criarExame(NUM_PACIENTES, NUM_MEDICOS, NUM_EMPRESAS, NUM_CARGOS));

                } catch (Exception e) {
                    tentativa++;
                    if (tentativa <= MAX_TENTATIVAS) {
                        System.out.println("Erro ao inserir dado na base, tentando novamente. Tentativa " + tentativa + " de " + MAX_TENTATIVAS);
                        i--;
                    } else {
                        throw new Exception("Número máximo de " + MAX_TENTATIVAS + " tentativas excedido ao tentar popular banco");
                    }
                }
            }
            tentativa = 0;
            for (int i = 0; i <= NUM_ATESTADOS; i++) {
                try {

                    atestadoDAO.inserir(dataBuilder.criarAtestado(NUM_EXAMES, NUM_PACIENTES, NUM_EMPRESAS, NUM_CARGOS, NUM_MEDICOS));
                } catch (Exception e) {
                    tentativa++;
                    if (tentativa <= MAX_TENTATIVAS) {
                        System.out.println("Erro ao inserir dado na base, tentando novamente. Tentativa " + tentativa + " de " + MAX_TENTATIVAS);
                        i--;
                    } else {
                        throw new Exception("Número máximo de " + MAX_TENTATIVAS + " tentativas excedido ao tentar popular banco");
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Deu ruim");
            //Lançar mensagem de erro na tela e deletar o conteúdo parcial criada na base.
        }
    }
}