package io.github.henriquemcc.agenda.kotlin.ui

import android.system.Os.remove
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import io.github.henriquemcc.agenda.kotlin.model.Aluno
import io.github.henriquemcc.agenda.kotlin.ui.adapter.ListaAlunosAdapter

class ListaAlunosView {

    fun confirmaRemocao(item: MenuItem) {
        AlertDialog.Builder(this)
            .setTitle("Removendo aluno")
            .setMessage("Tem certeza que quer remover o aluno?")
            .setPositiveButton("Sim") { _, _ ->
                val menuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
                val alunoEscolhido = adapter.getItem(menuInfo.position)
                remove(alunoEscolhido)
            }
            .setNegativeButton("Não", null)
            .show()
    }

    fun atualizaAlunos()
    {
        adapter.atualiza(dao.todos())
    }

    fun remove(aluno: Aluno)
    {
        dao.remove(aluno)
        adapter.remove(aluno)
    }

    fun configuraAdapter(listaDeAlunos: ListView?)
    {
        adapter = ListaAlunosAdapter(this)
        listaDeAlunos?.adapter = adapter
    }
}