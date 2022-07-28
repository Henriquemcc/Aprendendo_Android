package io.github.henriquemcc.agenda.kotlin.model

import java.io.Serializable

class Aluno(var nome: String = "", var telefone: String = "", var email: String = ""): Serializable
{
	var id: Int = 0

	override fun toString(): String
	{
		return nome;
	}

	fun temIdValido(): Boolean
	{
		return id > 0
	}
}
