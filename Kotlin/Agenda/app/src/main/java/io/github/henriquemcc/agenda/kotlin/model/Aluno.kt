package io.github.henriquemcc.agenda.kotlin.model

import java.io.Serializable

class Aluno(val nome: String, val telefone: String, val email: String): Serializable
{
	override fun toString(): String
	{
		return nome;
	}
}
