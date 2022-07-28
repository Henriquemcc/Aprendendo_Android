package io.github.henriquemcc.agenda.java.model;

import java.io.Serializable;

public class Aluno implements Serializable
{
	private final String nome;
	private final String telefone;
	private final String email;
	private int id = 0;

	public Aluno(String nome, String telefone, String email)
	{
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome()
	{
		return nome;
	}

	public String getTelefone()
	{
		return telefone;
	}

	public String getEmail()
	{
		return email;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return nome;
	}
}