package io.github.henriquemcc.agenda.java.dao;

import java.util.ArrayList;
import java.util.List;

import io.github.henriquemcc.agenda.java.model.Aluno;

public class AlunoDAO
{
	private final static List<Aluno> alunos = new ArrayList<>();
	private static int contadorDeIds = 1;

	public void salva(Aluno aluno)
	{
		aluno.setId(contadorDeIds);
		alunos.add(aluno);
		atualizaIds();
	}

	private void atualizaIds()
	{
		contadorDeIds++;
	}

	public Aluno buscaAlunoPeloId(Aluno aluno)
	{
		if (aluno != null)
		{
			for (int indice = 0; indice < alunos.size(); indice++)
			{
				if (alunos.get(indice) != null)
				{
					if (alunos.get(indice).getId() == aluno.getId())
					{
						return alunos.get(indice);
					}
				}
			}
		}
		return null;
	}

	public void edita(Aluno aluno) {
		Aluno alunoEncontrado = buscaAlunoPeloId(aluno);
		if (alunoEncontrado != null)
		{
			int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
			alunos.set(posicaoDoAluno, aluno);
		}
	}

	public void remove(Aluno aluno)
	{
		Aluno alunoDevolvido = buscaAlunoPeloId(aluno);
		if (alunoDevolvido != null)
		{
			alunos.remove(alunoDevolvido);
		}
	}

	public List<Aluno> todos()
	{
		return new ArrayList<>(alunos);
	}
}
