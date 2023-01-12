package io.github.henriquemcc.agenda.kotlin.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.github.henriquemcc.agenda.kotlin.R
import io.github.henriquemcc.agenda.kotlin.model.Aluno
import io.github.henriquemcc.agenda.kotlin.ui.ListaAlunosView
import io.github.henriquemcc.agenda.kotlin.ui.activity.ConstantesActivities.Companion.CHAVE_ALUNO

class ListaAlunosActivity : AppCompatActivity()
{
	private val TITULO_APPBAR = "Lista de alunos"
	private val listaAlunosView = ListaAlunosView(this)

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_lista_alunos)
		title = TITULO_APPBAR
		configuraFabNovoAluno()
		configuraLista()
	}

	override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
	{
		super.onCreateContextMenu(menu, v, menuInfo)
		menuInflater.inflate(R.menu.activity_lista_alunos_menu, menu)
	}

	override fun onContextItemSelected(item: MenuItem): Boolean
	{
		val itemId = item.itemId
		if (itemId == R.id.activity_lista_alunos_menu_remover)
		{
			listaAlunosView.confirmaRemocao(item)
		}

		return super.onContextItemSelected(item)
	}

	private fun configuraFabNovoAluno()
	{
		val botaoNovoAluno = findViewById<FloatingActionButton>(R.id.activity_lista_alunos_fab_novo_aluno)
		botaoNovoAluno.setOnClickListener { abreFormularioModoInsereAluno() }
	}

	private fun abreFormularioModoInsereAluno()
	{
		startActivity(Intent(this@ListaAlunosActivity, FormularioAlunoActivity::class.java))
	}

	override fun onResume()
	{
		super.onResume()
		listaAlunosView.atualizaAlunos()
	}

	private fun configuraLista()
	{
		val listaDeAlunos = findViewById<ListView>(R.id.activity_lista_alunos_listview)
		listaAlunosView.configuraAdapter(listaDeAlunos)
		configuraListenerDeCliquePorItem(listaDeAlunos)
		registerForContextMenu(listaDeAlunos)
	}

	private fun configuraListenerDeCliquePorItem(listaDeAlunos: ListView)
	{
		listaDeAlunos.onItemClickListener =
			AdapterView.OnItemClickListener { adapterView, p1, posicao, id ->
				val alunoEscolhido = adapterView?.getItemAtPosition(posicao) as Aluno
				Log.i("idAluno", alunoEscolhido.id.toString())
				abreFormularioModoEditaAluno(alunoEscolhido)
			}
	}

	private fun abreFormularioModoEditaAluno(aluno: Aluno)
	{
		val vaiParaFormularioActivity = Intent(this@ListaAlunosActivity, FormularioAlunoActivity::class.java)
		vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno)
		startActivity(vaiParaFormularioActivity)
	}
}