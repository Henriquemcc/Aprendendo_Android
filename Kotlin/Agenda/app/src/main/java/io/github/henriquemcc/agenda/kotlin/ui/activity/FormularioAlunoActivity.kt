package io.github.henriquemcc.agenda.kotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import io.github.henriquemcc.agenda.kotlin.R
import io.github.henriquemcc.agenda.kotlin.dao.AlunoDAO
import io.github.henriquemcc.agenda.kotlin.model.Aluno

class FormularioAlunoActivity : AppCompatActivity(), ConstantesActivities
{
	private val TITULO_APPBAR_NOVO_ALUNO = "Novo aluno"
	private val TITULO_APPBAR_EDITA_ALUNO = "Edita aluno"
	private var campoNome: EditText? = null
	private var campoTelefone: EditText? = null
	private var campoEmail: EditText? = null
	private val dao = AlunoDAO()
	private var aluno = Aluno()

	@RequiresApi(33)
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_formulario_aluno)
		inicializacaoDosCampos()
		configuraBotaoSalvar()
		carregaAluno()
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		menuInflater.inflate(R.menu.activity_formulario_aluno_menu, menu)
		return super.onCreateOptionsMenu(menu)
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		val itemId = item.itemId
		if (itemId == R.id.activity_formulario_aluno_menu_salvar)
		{
			finalizaFormulario()
		}
		return super.onOptionsItemSelected(item)
	}

	@RequiresApi(33)
	private fun carregaAluno()
	{
		val dados = intent

		if (dados.hasExtra(CHAVE_ALUNO))
		{
			title = TITULO_APPBAR_EDITA_ALUNO
			if (dados.getSerializableExtra(CHAVE_ALUNO, Aluno::class.java) != null)
			{
				aluno = dados.getSerializableExtra(CHAVE_ALUNO, Aluno::class.java)!!
			}
			preencheCampos()
		}
		else
		{
			title = TITULO_APPBAR_NOVO_ALUNO
		}
	}

	private fun preencheCampos()
	{
		campoNome?.setText(aluno.nome)
		campoTelefone?.setText(aluno.telefone)
		campoEmail?.setText(aluno.email)
	}

	private fun configuraBotaoSalvar()
	{
		val botaoSalvar = findViewById<Button>(R.id.activity_formulario_aluno_botao_salvar)
		botaoSalvar.setOnClickListener(object : View.OnClickListener
		{
			override fun onClick(p0: View?)
			{
				finalizaFormulario()
			}
		})
	}

	private fun finalizaFormulario()
	{
		preencheAluno()
		if (aluno.temIdValido())
		{
			dao.edita(aluno)
		}
		else
		{
			dao.salva(aluno)
		}
		finish()
	}

	private fun inicializacaoDosCampos()
	{
		campoNome = findViewById(R.id.activity_formulario_aluno_nome)
		campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone)
		campoEmail = findViewById(R.id.activity_formulario_aluno_email)
	}

	private fun preencheAluno()
	{
		val nome = campoNome?.text.toString()
		val telefone = campoTelefone?.text.toString()
		val email = campoEmail?.text.toString()

		aluno.nome = nome
		aluno.telefone = telefone
		aluno.email = email
	}
}