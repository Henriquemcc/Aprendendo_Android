package io.github.henriquemcc.agenda.java;

import android.app.Application;

import io.github.henriquemcc.agenda.java.dao.AlunoDAO;
import io.github.henriquemcc.agenda.java.model.Aluno;

public class AgendaApplication extends Application
{
	@Override
	public void onCreate()
	{
		super.onCreate();
		criaAlunosDeTeste();
	}

	private void criaAlunosDeTeste()
	{
		AlunoDAO dao = new AlunoDAO();
		dao.salva(new Aluno("João da Silva", "+55 00 9999-9999", "joao@gmail.com"));
		dao.salva(new Aluno("José da Silva", "+55 00 9999-8888", "jose@gmail.com"));
	}
}
