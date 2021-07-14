package io.github.henriquemcc.agenda.dao

import io.github.henriquemcc.agenda.model.Aluno

class AlunoDataAccessObject {

    companion object {
        private val alunos = ArrayList<Aluno>()
    }

    fun salvar(aluno: Aluno) {
        alunos.add(aluno)
    }

    fun todos(): List<Aluno> {
        return ArrayList<Aluno>(alunos)
    }

}
