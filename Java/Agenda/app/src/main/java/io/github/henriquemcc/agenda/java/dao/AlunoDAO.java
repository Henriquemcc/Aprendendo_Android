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

	public void edita(Aluno aluno) {
		if (aluno != null)
		{
			for (int indice = 0; indice < alunos.size(); indice++)
			{
				if (alunos.get(indice) != null)
				{
					if (alunos.get(indice).getId() == aluno.getId())
					{
						alunos.set(indice, aluno);
						break;
					}
				}
			}
		}
	}

	public List<Aluno> todos()
	{
		return new ArrayList<>(alunos);
	}
}
