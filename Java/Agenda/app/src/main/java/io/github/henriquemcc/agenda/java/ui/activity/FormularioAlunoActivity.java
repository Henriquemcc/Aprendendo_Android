package io.github.henriquemcc.agenda.java.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.github.henriquemcc.agenda.java.R;
import io.github.henriquemcc.agenda.java.dao.AlunoDAO;
import io.github.henriquemcc.agenda.java.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity implements ConstantesActivities
{
	private final String TITULO_APPBAR_NOVO_ALUNO = "Novo aluno";
	private final String TITULO_APPBAR_EDITA_ALUNO = "Edita aluno";
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
		inicializacaoDosCampos();
		configuraBotaoSalvar();
		carregaAluno();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_formulario_aluno_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		final int itemId = item.getItemId();
		if (itemId == R.id.activity_formulario_aluno_menu_salvar)
		{
			finalizaFormulario();
		}
		return super.onOptionsItemSelected(item);
	}

	private void carregaAluno()
	{
		Intent dados = getIntent();
		if (dados.hasExtra(CHAVE_ALUNO))
		{
			setTitle(TITULO_APPBAR_EDITA_ALUNO);
			aluno = (Aluno) dados.getSerializableExtra(CHAVE_ALUNO);
			preencheCampos();
		}
		else
		{
			setTitle(TITULO_APPBAR_NOVO_ALUNO);
			aluno = new Aluno();
		}
	}

	private void preencheCampos()
	{
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
						finalizaFormulario();
					}
				}
		);
	}

	private void finalizaFormulario()
	{
		preencheAluno();
		if (aluno.temIdValido())
		{
			dao.edita(aluno);
		}
		else
		{
			dao.salva(aluno);
		}
		finish();
	}

	private void inicializacaoDosCampos()
	{
		campoNome = findViewById(R.id.activity_formulario_aluno_nome);
		campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
		campoEmail = findViewById(R.id.activity_formulario_aluno_email);
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
}