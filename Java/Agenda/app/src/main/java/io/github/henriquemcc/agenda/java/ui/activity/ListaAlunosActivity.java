package io.github.henriquemcc.agenda.java.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;
import java.util.List;

import io.github.henriquemcc.agenda.java.R;
import io.github.henriquemcc.agenda.java.dao.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity
{
	private final String TITULO_APPBAR = "Lista de alunos";
	private final AlunoDAO dao = new AlunoDAO();
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
				abreFormularioAlunoActivity();
			}
		});
	}

	private void abreFormularioAlunoActivity()
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
		final ListView listViewListaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
		listViewListaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
	}
}
