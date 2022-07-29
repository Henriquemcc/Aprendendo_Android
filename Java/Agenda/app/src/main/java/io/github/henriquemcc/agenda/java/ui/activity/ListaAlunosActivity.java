package io.github.henriquemcc.agenda.java.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import io.github.henriquemcc.agenda.java.R;
import io.github.henriquemcc.agenda.java.dao.AlunoDAO;
import io.github.henriquemcc.agenda.java.model.Aluno;

public class ListaAlunosActivity extends AppCompatActivity implements ConstantesActivities
{
	private final String TITULO_APPBAR = "Lista de alunos";
	private final AlunoDAO dao = new AlunoDAO();
	private ArrayAdapter arrayAdapter;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_alunos);
		setTitle(TITULO_APPBAR);
		configuraFabNovoAluno();
	}

	private void configuraFabNovoAluno()
	{
		final FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
		botaoNovoAluno.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				abreFormularioModoInsereAluno();
			}
		});
	}

	private void abreFormularioModoInsereAluno()
	{
		startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		configuraLista();
	}

	private void configuraLista()
	{
		final ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
		final List<Aluno> alunos = dao.todos();
		configuraAdapter(listaDeAlunos, alunos);
		configuraListenerDeCliquePorItem(listaDeAlunos);
		listaDeAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
		{
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicao, long id)
			{
				Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
				dao.remove(alunoEscolhido);
				arrayAdapter.remove(alunoEscolhido);
				return true;
			}
		});
	}

	private void configuraListenerDeCliquePorItem(ListView listaDeAlunos)
	{
		listaDeAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id)
			{
				Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
				Log.i("idAluno", String.valueOf(alunoEscolhido.getId()));
				abreFormularioModoEditaAluno(alunoEscolhido);
			}
		});
	}

	private void abreFormularioModoEditaAluno(Aluno alunoEscolhido)
	{
		Intent vaiParaFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
		vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, alunoEscolhido);
		startActivity(vaiParaFormularioActivity);
	}

	private void configuraAdapter(ListView listaDeAlunos, List<Aluno> alunos)
	{
		arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos);
		listaDeAlunos.setAdapter(arrayAdapter);
	}
}
