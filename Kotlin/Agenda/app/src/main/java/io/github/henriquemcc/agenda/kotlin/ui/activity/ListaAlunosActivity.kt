package io.github.henriquemcc.agenda.kotlin.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import io.github.henriquemcc.agenda.kotlin.R

class ListaAlunosActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alunos)
        title = "Lista de alunos"

        // Lista de alunos
        val alunos = listOf<String>("João", "José", "Maria", "Carlos", "Gabriel", "Ana")

        // List View com os alunos
        val listViewListaDeAlunos = findViewById<ListView>(R.id.activity_lista_alunos_listview)

        // Adicionando adaptador com uma lista simples de itens
        listViewListaDeAlunos.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, alunos)
    }
}