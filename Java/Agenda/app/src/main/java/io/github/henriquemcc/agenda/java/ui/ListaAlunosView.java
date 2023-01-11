package io.github.henriquemcc.agenda.java.ui;

import android.app.AlertDialog;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import io.github.henriquemcc.agenda.java.model.Aluno;
import io.github.henriquemcc.agenda.java.ui.adapter.ListaAlunosAdapter;

public class ListaAlunosView
{

	public void confirmaRemocao(@NonNull final MenuItem item)
	{
		new AlertDialog.Builder(this).setTitle("Removendo aluno").setMessage("Tem certeza que quer remover o aluno?").setPositiveButton("Sim", (dialogInterface, i) ->
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

	public void remove(Aluno aluno)
	{
		dao.remove(aluno);
		adapter.remove(aluno);
	}

	public void configuraAdapter(ListView listaDeAlunos)
	{
		adapter = new ListaAlunosAdapter(this);
		listaDeAlunos.setAdapter(adapter);
	}
}
