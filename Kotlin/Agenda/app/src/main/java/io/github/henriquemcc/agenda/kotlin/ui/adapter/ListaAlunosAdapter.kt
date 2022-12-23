package io.github.henriquemcc.agenda.kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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

    override fun getView(p0: Int, p1: View?, viewGroup: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.item_aluno, viewGroup, false)
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