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
		contadorDeIds++
	}

	fun edita(aluno: Aluno)
	{
		for(index in 0..alunos.size)
		{
			if (aluno.id == alunos[index].id)
			{
				alunos[index] = aluno
				break
			}
		}
	}

	fun todos(): List<Aluno>
	{
		return ArrayList(alunos)
	}
}