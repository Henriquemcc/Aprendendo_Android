package io.github.henriquemcc.agenda.java.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.github.henriquemcc.agenda.java.R;
import io.github.henriquemcc.agenda.java.dao.AlunoDAO;
import io.github.henriquemcc.agenda.java.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity
{
	private final String TITULO_APPBAR = "Novo aluno";
	private final AlunoDAO dao = new AlunoDAO();
	private EditText campoNome;
	private EditText campoTelefone;
	private EditText campoEmail;
	private Aluno aluno;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_formulario_aluno);
		setTitle(TITULO_APPBAR);
		inicializacaoDosCampos();
		configuraBotaoSalvar();

		Intent dados = getIntent();
		aluno = (Aluno) dados.getSerializableExtra("aluno");

		if (aluno != null)
		{
			campoNome.setText(aluno.getNome());
			campoEmail.setText(aluno.getEmail());
			campoTelefone.setText(aluno.getTelefone());
		}
	}

	private void configuraBotaoSalvar()
	{
		final Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
		botaoSalvar.setOnClickListener(
				new View.OnClickListener()
				{

					@Override
					public void onClick(View view)
					{
						preencheAluno();
						dao.edita(aluno);
						finish();
					}
				}
		);
	}

	private void preencheAluno()
	{
		final String nome = campoNome.getText().toString();
		final String telefone = campoTelefone.getText().toString();
		final String email = campoEmail.getText().toString();

		aluno.setNome(nome);
		aluno.setTelefone(telefone);
		aluno.setEmail(email);
	}

	private void salva(Aluno aluno)
	{
		dao.salva(aluno);
		finish();
	}

	private void inicializacaoDosCampos()
	{
		campoNome = findViewById(R.id.activity_formulario_aluno_nome);
		campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
		campoEmail = findViewById(R.id.activity_formulario_aluno_email);
	}
}