package io.github.henriquemcc.agenda.kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import io.github.henriquemcc.agenda.kotlin.R
import io.github.henriquemcc.agenda.kotlin.model.Aluno

class ListaAlunosAdapter(val context: Context):  BaseAdapter(){

    val alunos = ArrayList<Aluno>()

    override fun getCount(): Int {
        return alunos.size
    }

    override fun getItem(posicao: Int): Aluno {
        return alunos[posicao]
    }

    override fun getItemId(posicao: Int): Long {
        return alunos[posicao].id.toLong()
    }

    override fun getView(posicao: Int, view: View?, viewGroup: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context).inflate(R.layout.item_aluno, viewGroup, false)
        val alunoDevolvido = alunos.get(posicao)
        val nome = viewCriada.findViewById<TextView>(R.id.item_aluno_nome)
        nome.text = alunoDevolvido.nome
        val telefone = viewCriada.findViewById<TextView>(R.id.item_aluno_telefone)
        telefone.text = alunoDevolvido.telefone
        return viewCriada
    }

    fun clear()
    {
        alunos.clear()
    }

    fun addAll(alunos: List<Aluno>)
    {
        this.alunos.addAll(alunos)
    }

    fun remove(aluno: Aluno)
    {
        alunos.remove(aluno)
    }

}