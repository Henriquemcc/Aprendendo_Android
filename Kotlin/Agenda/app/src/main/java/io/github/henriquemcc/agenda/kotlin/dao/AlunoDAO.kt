package io.github.henriquemcc.agenda.kotlin.dao

import io.github.henriquemcc.agenda.kotlin.model.Aluno

class AlunoDAO
{
	companion object
	{
		private val alunos = ArrayList<Aluno>()
	}

	fun salva(aluno: Aluno)
	{
		alunos.add(aluno)
	}

	fun todos(): List<Aluno>
	{
		return ArrayList(alunos)
	}
}