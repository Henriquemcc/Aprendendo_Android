package io.github.henriquemcc.agenda.kotlin

import android.app.Application
import io.github.henriquemcc.agenda.kotlin.dao.AlunoDAO
import io.github.henriquemcc.agenda.kotlin.model.Aluno

class AgendaApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        criaAlunoDeTeste()
    }

    private fun criaAlunoDeTeste() {
        val dao = AlunoDAO()
        dao.salva(Aluno("João da Silva", "+55 00 9999-9999", "joao@gmail.com"))
        dao.salva(Aluno("José da Silva", "+55 00 9999-8888", "jose@gmail.com"))
    }
}