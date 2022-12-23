package io.github.henriquemcc.agenda.java.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.github.henriquemcc.agenda.java.R;
import io.github.henriquemcc.agenda.java.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter
{

	private final List<Aluno> alunos = new ArrayList<>();
	private Context context;

	public ListaAlunosAdapter(Context context)
	{
		this.context = context;
	}

	@Override
	public int getCount()
	{
		return alunos.size();
	}

	@Override
	public Aluno getItem(int posicao)
	{
		return alunos.get(posicao);
	}

	@Override
	public long getItemId(int posicao)
	{
		return alunos.get(posicao).getId();
	}

	@Override
	public View getView(int posicao, View view, ViewGroup viewGroup)
	{
		final View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_aluno, viewGroup, false);
		final Aluno alunoDevolvido = alunos.get(posicao);
		final TextView nome = viewCriada.findViewById(R.id.item_aluno_nome);
		nome.setText(alunoDevolvido.getNome());
		final TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);
		telefone.setText(alunoDevolvido.getTelefone());
		return viewCriada;
	}

	public void clear()
	{
		alunos.clear();
	}

	public void addAll(List<Aluno> alunos)
	{
		this.alunos.addAll(alunos);
	}

	public void remove(Aluno aluno)
	{
		alunos.remove(aluno);
	}
}
