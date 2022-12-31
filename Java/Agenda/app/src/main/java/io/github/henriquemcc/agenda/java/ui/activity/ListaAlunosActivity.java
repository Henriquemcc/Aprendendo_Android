package io.github.henriquemcc.agenda.java.ui.activity;

import static io.github.henriquemcc.agenda.java.ui.activity.ConstantesActivities.CHAVE_ALUNO;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.github.henriquemcc.agenda.java.R;
import io.github.henriquemcc.agenda.java.dao.AlunoDAO;
import io.github.henriquemcc.agenda.java.model.Aluno;
import io.github.henriquemcc.agenda.java.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosActivity extends AppCompatActivity
{
	public static final String TITULO_APPBAR = "Lista de alunos";
	private final AlunoDAO dao = new AlunoDAO();
	private ListaAlunosAdapter adapter;
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_alunos);
		setTitle(TITULO_APPBAR);
		configuraFabNovoAluno();
		configuraLista();
		new AlertDialog.Builder(this)
				.setTitle("Removendo aluno")
				.setMessage("Tem certeza que quer remover o aluno?")
				.setPositiveButton("Sim", null)
				.setNegativeButton("Não", null)
				.show();
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
	{
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.activity_lista_alunos_menu, menu);
	}

	@Override
	public boolean onContextItemSelected(@NonNull MenuItem item)
	{
		final int itemId = item.getItemId();
		if (itemId == R.id.activity_lista_alunos_menu_remover)
		{
			final AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
			final Aluno alunoEscolhido = (Aluno) adapter.getItem(menuInfo.position);
			remove(alunoEscolhido);
		}

		return super.onContextItemSelected(item);
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
		atualizaAlunos();
	}

	private void atualizaAlunos()
	{
		adapter.atualiza(dao.todos());
	}

	private void configuraLista()
	{
		final ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
		configuraAdapter(listaDeAlunos);
		configuraListenerDeCliquePorItem(listaDeAlunos);
		registerForContextMenu(listaDeAlunos);
	}

	private void remove(Aluno aluno)
	{
		dao.remove(aluno);
		adapter.remove(aluno);
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

	private void configuraAdapter(ListView listaDeAlunos)
	{
		adapter = new ListaAlunosAdapter(this);
		listaDeAlunos.setAdapter(adapter);
	}
}
