package io.github.henriquemcc.agenda.kotlin.ui.activity

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.github.henriquemcc.agenda.kotlin.R
import io.github.henriquemcc.agenda.kotlin.dao.AlunoDAO
import io.github.henriquemcc.agenda.kotlin.model.Aluno
import io.github.henriquemcc.agenda.kotlin.ui.activity.ConstantesActivities.Companion.CHAVE_ALUNO
import io.github.henriquemcc.agenda.kotlin.ui.adapter.ListaAlunosAdapter

class ListaAlunosActivity : AppCompatActivity()
{
	private val TITULO_APPBAR = "Lista de alunos"
	private val dao = AlunoDAO()
	private lateinit var adapter: ListaAlunosAdapter

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
			AlertDialog.Builder(this)
				.setTitle("Removendo aluno")
				.setMessage("Tem certeza que quer remover o aluno?")
				.setPositiveButton("Sim", object: DialogInterface.OnClickListener {
					override fun onClick(p0: DialogInterface?, p1: Int) {
						val menuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
						val alunoEscolhido = adapter.getItem(menuInfo.position)
						remove(alunoEscolhido)
					}
				})
				.setNegativeButton("Não", null)
				.show()
		}

		return super.onContextItemSelected(item)
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
		adapter.atualiza(dao.todos())
	}

	private fun configuraLista()
	{
		val listaDeAlunos = findViewById<ListView>(R.id.activity_lista_alunos_listview)
		configuraAdapter(listaDeAlunos)
		configuraListenerDeCliquePorItem(listaDeAlunos)
		registerForContextMenu(listaDeAlunos)
	}

	private fun remove(aluno: Aluno)
	{
		dao.remove(aluno)
		adapter.remove(aluno)
	}

	private fun configuraListenerDeCliquePorItem(listaDeAlunos: ListView)
	{
		listaDeAlunos.onItemClickListener = object : AdapterView.OnItemClickListener {
			override fun onItemClick(adapterView: AdapterView<*>?, p1: View?, posicao: Int, id: Long) {
				val alunoEscolhido = adapterView?.getItemAtPosition(posicao) as Aluno
				Log.i("idAluno", alunoEscolhido.id.toString())
				abreFormularioModoEditaAluno(alunoEscolhido)
			}

		}
	}

	private fun abreFormularioModoEditaAluno(aluno: Aluno)
	{
		val vaiParaFormularioActivity = Intent(this@ListaAlunosActivity, FormularioAlunoActivity::class.java)
		vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno)
		startActivity(vaiParaFormularioActivity)
	}

	private fun configuraAdapter(listaDeAlunos: ListView?)
	{
		adapter = ListaAlunosAdapter(this)
		listaDeAlunos?.adapter = adapter
	}
}