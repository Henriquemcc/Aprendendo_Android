package io.github.henriquemcc.agenda.java.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
	public View getView(int i, View view, ViewGroup viewGroup)
	{
		return LayoutInflater.from(context).inflate(R.layout.item_aluno, viewGroup, false);
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
