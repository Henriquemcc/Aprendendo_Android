package io.github.henriquemcc.agenda.kotlin.ui

import android.content.Context
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import io.github.henriquemcc.agenda.kotlin.dao.AlunoDAO
import io.github.henriquemcc.agenda.kotlin.model.Aluno
import io.github.henriquemcc.agenda.kotlin.ui.adapter.ListaAlunosAdapter

class ListaAlunosView(private val context: Context) {

    private val adapter: ListaAlunosAdapter = ListaAlunosAdapter(context)
    private val dao: AlunoDAO = AlunoDAO()

    fun confirmaRemocao(item: MenuItem) {
        AlertDialog.Builder(context)
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

    private fun remove(aluno: Aluno)
    {
        dao.remove(aluno)
        adapter.remove(aluno)
    }

    fun configuraAdapter(listaDeAlunos: ListView?)
    {
        listaDeAlunos?.adapter = adapter
    }
}