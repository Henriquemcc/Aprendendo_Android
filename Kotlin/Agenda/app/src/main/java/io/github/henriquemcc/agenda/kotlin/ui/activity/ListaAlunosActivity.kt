package io.github.henriquemcc.agenda.kotlin.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.github.henriquemcc.agenda.kotlin.R
import io.github.henriquemcc.agenda.kotlin.dao.AlunoDAO

class ListaAlunosActivity : AppCompatActivity()
{
	private val TITULO_APPBAR = "Lista de alunos"
	private val dao = AlunoDAO()

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_lista_alunos)
		title = TITULO_APPBAR
		configuraFabNovoAluno()
	}

	private fun configuraFabNovoAluno()
	{
		val botaoNovoAluno = findViewById<FloatingActionButton>(R.id.activity_lista_alunos_fab_novo_aluno)
		botaoNovoAluno.setOnClickListener(object : View.OnClickListener
		{
			override fun onClick(p0: View?)
			{
				abreFormularioAlunoActivity()
			}
		})
	}

	private fun abreFormularioAlunoActivity()
	{
		startActivity(Intent(this@ListaAlunosActivity, FormularioAlunoActivity::class.java))
	}

	override fun onResume()
	{
		super.onResume()
		configuraLista()
	}

	private fun configuraLista()
	{
		val listaDeAlunos = findViewById<ListView>(R.id.activity_lista_alunos_listview)
		val alunos = dao.todos()
		listaDeAlunos.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dao.todos())
		listaDeAlunos.setOnItemClickListener(object : AdapterView.OnItemClickListener
		{
			override fun onItemClick(p0: AdapterView<*>?, p1: View?, posicao: Int, id: Long)
			{
				val alunoEscolhido = alunos.get(posicao)
				Log.i("idAluno", alunoEscolhido.id.toString())
				val vaiParaFormularioActivity = Intent(this@ListaAlunosActivity, FormularioAlunoActivity::class.java)
				vaiParaFormularioActivity.putExtra("aluno", alunoEscolhido)
				startActivity(vaiParaFormularioActivity)
			}

		})
	}
}