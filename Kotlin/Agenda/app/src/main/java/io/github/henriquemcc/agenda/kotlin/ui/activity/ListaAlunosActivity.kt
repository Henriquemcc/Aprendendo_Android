package io.github.henriquemcc.agenda.kotlin.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.github.henriquemcc.agenda.kotlin.R
import io.github.henriquemcc.agenda.kotlin.dao.AlunoDAO

class ListaAlunosActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_lista_alunos)

		title = "Lista de alunos"

		val botaoNovoAluno = findViewById<FloatingActionButton>(R.id.activity_lista_alunos_fab_novo_aluno)
		botaoNovoAluno.setOnClickListener(object : View.OnClickListener
		{
			override fun onClick(p0: View?)
			{
                startActivity(Intent(this@ListaAlunosActivity, FormularioAlunoActivity::class.java))
			}
		})
	}

	override fun onResume()
	{
		super.onResume()

		val dao = AlunoDAO()

		val listaDeAlunos = findViewById<ListView>(R.id.activity_lista_alunos_listview)
		listaDeAlunos.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dao.todos())
	}
}