package io.github.henriquemcc.agenda.kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import io.github.henriquemcc.agenda.kotlin.R
import io.github.henriquemcc.agenda.kotlin.model.Aluno

class ListaAlunosAdapter(private val context: Context):  BaseAdapter(){

    private val alunos = ArrayList<Aluno>()

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
        val viewCriada = criaView(viewGroup)
        val alunoDevolvido = alunos[posicao]
        vincula(viewCriada, alunoDevolvido)
        return viewCriada
    }

    private fun criaView(viewGroup: ViewGroup?) =
        LayoutInflater.from(context).inflate(R.layout.item_aluno, viewGroup, false)

    private fun vincula(view: View, aluno: Aluno) {
        val nome = view.findViewById<TextView>(R.id.item_aluno_nome)
        nome.text = aluno.nome
        val telefone = view.findViewById<TextView>(R.id.item_aluno_telefone)
        telefone.text = aluno.telefone
    }

    fun atualiza(alunos: List<Aluno>)
    {
        this.alunos.clear()
        this.alunos.addAll(alunos)
        notifyDataSetChanged()
    }

    fun remove(aluno: Aluno)
    {
        alunos.remove(aluno)
        notifyDataSetChanged()
    }

}