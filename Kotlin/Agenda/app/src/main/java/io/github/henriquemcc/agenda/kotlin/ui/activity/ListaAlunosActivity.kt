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
import io.github.henriquemcc.agenda.kotlin.model.Aluno

class ListaAlunosActivity : AppCompatActivity(), ConstantesActivities
{
	private val TITULO_APPBAR = "Lista de alunos"
	private val dao = AlunoDAO()
	private var adapter: ArrayAdapter<Any>? = null

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_lista_alunos)
		title = TITULO_APPBAR
		configuraFabNovoAluno()
		configuraLista()
	}

	private fun configuraFabNovoAluno()
	{
		val botaoNovoAluno = findViewById<FloatingActionButton>(R.id.activity_lista_alunos_fab_novo_aluno)
		botaoNovoAluno.setOnClickListener(object : View.OnClickListener
		{
			override fun onClick(p0: View?)
			{
				abreFormularioModoInsereAluno()
			}
		})
	}

	private fun abreFormularioModoInsereAluno()
	{
		startActivity(Intent(this@ListaAlunosActivity, FormularioAlunoActivity::class.java))
	}

	override fun onResume()
	{
		super.onResume()
		atualizaAlunos()
	}

	private fun atualizaAlunos()
	{
		adapter?.clear()
		adapter?.addAll(dao.todos())
	}

	private fun configuraLista()
	{
		val listaDeAlunos = findViewById<ListView>(R.id.activity_lista_alunos_listview)
		configuraAdapter(listaDeAlunos)
		configuraListenerDeCliquePorItem(listaDeAlunos)
		configurarListenerDeCliqueLongoPorItem(listaDeAlunos)
	}

	private fun configurarListenerDeCliqueLongoPorItem(listaDeAlunos: ListView)
	{
		listaDeAlunos.setOnItemLongClickListener(object : AdapterView.OnItemLongClickListener
		{
			override fun onItemLongClick(adapterView: AdapterView<*>?, p1: View?, posicao: Int, id: Long): Boolean
			{
				val alunoEscolhido = adapterView?.getItemAtPosition(posicao) as Aluno
				remove(alunoEscolhido)
				return true
			}
		})
	}

	private fun remove(aluno: Aluno)
	{
		dao.remove(aluno)
		adapter?.remove(aluno)
	}

	private fun configuraListenerDeCliquePorItem(listaDeAlunos: ListView)
	{
		listaDeAlunos.setOnItemClickListener(object : AdapterView.OnItemClickListener
		{
			override fun onItemClick(adapterView: AdapterView<*>?, p1: View?, posicao: Int, id: Long)
			{
				val alunoEscolhido = adapterView?.getItemAtPosition(posicao) as Aluno
				Log.i("idAluno", alunoEscolhido.id.toString())
				abreFormularioModoEditaAluno(alunoEscolhido)
			}

		})
	}

	private fun abreFormularioModoEditaAluno(aluno: Aluno)
	{
		val vaiParaFormularioActivity = Intent(this@ListaAlunosActivity, FormularioAlunoActivity::class.java)
		vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno)
		startActivity(vaiParaFormularioActivity)
	}

	private fun configuraAdapter(listaDeAlunos: ListView?)
	{
		adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
		listaDeAlunos?.adapter = adapter
	}
}