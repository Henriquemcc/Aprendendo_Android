package io.github.henriquemcc.agenda.kotlin.model

class Aluno(val nome: String, val telefone: String, val email: String)
{
	override fun toString(): String
	{
		return nome;
	}
}
