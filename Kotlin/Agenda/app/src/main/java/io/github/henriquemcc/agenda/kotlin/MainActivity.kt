package io.github.henriquemcc.agenda.kotlin

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity: Activity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lista de alunos
        val alunos = listOf<String>("João", "José", "Maria", "Carlos", "Gabriel", "Ana")

        // List View com os alunos
        val listViewListaDeAlunos = findViewById<ListView>(R.id.activity_main_lista_de_alunos)

        // Adicionando adaptador com uma lista simples de itens
        listViewListaDeAlunos.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, alunos)
    }
}