package io.github.henriquemcc.agenda.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import io.github.henriquemcc.agenda.R

class ListaAlunosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alunos)
        title = "Lista de alunos"
        val alunos = arrayListOf("Alex", "José", "Fran", "Maria", "Ana")
        val listaDeAlunos = findViewById<ListView>(R.id.activity_lista_de_alunos_listview)
        listaDeAlunos.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, alunos)
    }

}