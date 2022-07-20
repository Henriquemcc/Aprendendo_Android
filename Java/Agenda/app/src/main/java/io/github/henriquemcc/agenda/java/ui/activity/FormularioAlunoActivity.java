package io.github.henriquemcc.agenda.java.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.github.henriquemcc.agenda.java.R;
import io.github.henriquemcc.agenda.java.dao.AlunoDAO;
import io.github.henriquemcc.agenda.java.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_formulario_aluno);

		final AlunoDAO dao = new AlunoDAO();

		final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
		final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
		final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);

		final Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
		botaoSalvar.setOnClickListener(
				new View.OnClickListener()
				{

					@Override
					public void onClick(View view)
					{
						final String nome = campoNome.getText().toString();
						final String telefone = campoTelefone.getText().toString();
						final String email = campoEmail.getText().toString();

						Aluno alunoCriado = new Aluno(nome, telefone, email);
						dao.salva(alunoCriado);

						finish();
					}
				}
		);
	}
}