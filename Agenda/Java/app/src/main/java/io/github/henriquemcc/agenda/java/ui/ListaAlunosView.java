package io.github.henriquemcc.agenda.java.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import io.github.henriquemcc.agenda.java.dao.AlunoDAO;
import io.github.henriquemcc.agenda.java.model.Aluno;
import io.github.henriquemcc.agenda.java.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView
{
	private final ListaAlunosAdapter adapter;
	private final AlunoDAO dao;
	private final Context context;

	public ListaAlunosView(final Context context)
	{
		this.context = context;
		adapter = new ListaAlunosAdapter(context);
		dao = new AlunoDAO();
	}


	public void confirmaRemocao(@NonNull final MenuItem item)
	{
		new AlertDialog.Builder(context).setTitle("Removendo aluno").setMessage("Tem certeza que quer remover o aluno?").setPositiveButton("Sim", (dialogInterface, i) ->
		{
			final AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
			final Aluno alunoEscolhido = (Aluno) adapter.getItem(menuInfo.position);
			remove(alunoEscolhido);
		}).setNegativeButton("Não", null).show();
	}

	public void atualizaAlunos()
	{
		adapter.atualiza(dao.todos());
	}

	private void remove(Aluno aluno)
	{
		dao.remove(aluno);
		adapter.remove(aluno);
	}

	public void configuraAdapter(ListView listaDeAlunos)
	{
		listaDeAlunos.setAdapter(adapter);
	}
}
