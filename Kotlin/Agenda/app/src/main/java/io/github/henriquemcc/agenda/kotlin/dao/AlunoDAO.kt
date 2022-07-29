package io.github.henriquemcc.agenda.kotlin.dao

import io.github.henriquemcc.agenda.kotlin.model.Aluno

class AlunoDAO
{
	companion object
	{
		private val alunos = ArrayList<Aluno>()
		private var contadorDeIds = 1
	}

	fun salva(aluno: Aluno)
	{
		aluno.id = contadorDeIds
		alunos.add(aluno)
		atualizaIds()
	}

	private fun atualizaIds()
	{
		contadorDeIds++
	}

	private fun buscaAlunoPeloId(aluno: Aluno): Aluno?
	{
		for(index in 0..alunos.size)
		{
			if (aluno.id == alunos[index].id)
			{
				return alunos[index]
			}
		}
		return null
	}

	fun edita(aluno: Aluno)
	{
		val alunoEncontrado = buscaAlunoPeloId(aluno)

		if (alunoEncontrado != null)
		{
			val posicaoDoAluno = alunos.indexOf(alunoEncontrado)
			alunos.set(posicaoDoAluno, aluno)
		}
	}

	fun remove(aluno: Aluno)
	{
		val alunoDevolvido = buscaAlunoPeloId(aluno)
		if (alunoDevolvido != null)
		{
			alunos.remove(alunoDevolvido)
		}
	}

	fun todos(): List<Aluno>
	{
		return ArrayList(alunos)
	}
}