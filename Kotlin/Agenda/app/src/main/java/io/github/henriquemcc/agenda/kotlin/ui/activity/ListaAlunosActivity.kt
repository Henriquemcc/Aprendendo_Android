package io.github.henriquemcc.agenda.kotlin.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import io.github.henriquemcc.agenda.kotlin.R
import io.github.henriquemcc.agenda.kotlin.dao.AlunoDAO

class ListaAlunosActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alunos)

        val dao = AlunoDAO()

        title = "Lista de alunos"

        val listViewListaDeAlunos = findViewById<ListView>(R.id.activity_lista_alunos_listview)
        listViewListaDeAlunos.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dao.todos())
    }
}