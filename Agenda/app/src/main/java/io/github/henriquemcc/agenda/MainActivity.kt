package io.github.henriquemcc.agenda

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alunos = arrayListOf("Alex", "José", "Fran", "Maria", "Ana")
        val listaDeAlunos = findViewById<ListView>(R.id.activity_main_lista_de_alunos)
        listaDeAlunos.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, alunos)
    }

}