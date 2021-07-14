package io.github.henriquemcc.agenda.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.github.henriquemcc.agenda.R
import io.github.henriquemcc.agenda.dao.AlunoDataAccessObject

class ListaAlunosActivity : AppCompatActivity() {

    private val dataAccessObjectAluno = AlunoDataAccessObject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alunos)
        configurarFloatingActionButtonNovoAluno()
        title = "Lista de alunos"
    }

    private fun configurarFloatingActionButtonNovoAluno() {
        val botaoNovoAluno =
            findViewById<FloatingActionButton>(R.id.activity_lista_alunos_floatingActionButton_novo_aluno)
        botaoNovoAluno.setOnClickListener {
            abrirFormularioAlunoActivity()
        }
    }

    private fun abrirFormularioAlunoActivity() {
        startActivity(
            Intent(this, FormularioAlunoActivity().javaClass)
        )
    }

    override fun onResume() {
        super.onResume()
        configurarLista()
    }

    private fun configurarLista() {
        val listaDeAlunos = findViewById<ListView>(R.id.activity_lista_de_alunos_listview)
        listaDeAlunos.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, dataAccessObjectAluno.todos())
    }

}