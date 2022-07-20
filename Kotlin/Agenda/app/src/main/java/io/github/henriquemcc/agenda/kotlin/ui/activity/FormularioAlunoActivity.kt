package io.github.henriquemcc.agenda.kotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import io.github.henriquemcc.agenda.kotlin.R
import io.github.henriquemcc.agenda.kotlin.dao.AlunoDAO
import io.github.henriquemcc.agenda.kotlin.model.Aluno

class FormularioAlunoActivity : AppCompatActivity()
{
	private val TITULO_APPBAR = "Novo aluno"
	private var campoNome: EditText? = null
	private var campoTelefone: EditText? = null
	private var campoEmail: EditText? = null
	private val dao = AlunoDAO()

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_formulario_aluno)
		title = TITULO_APPBAR
		inicializacaoDosCampos()
		configuraBotaoSalvar()
	}

	private fun configuraBotaoSalvar()
	{
		val botaoSalvar = findViewById<Button>(R.id.activity_formulario_aluno_botao_salvar)
		botaoSalvar.setOnClickListener(object : View.OnClickListener
		{
			override fun onClick(p0: View?)
			{
				val alunoCriado = criaAluno()
				salva(alunoCriado)
			}
		})
	}

	private fun inicializacaoDosCampos()
	{
		campoNome = findViewById<EditText>(R.id.activity_formulario_aluno_nome)
		campoTelefone = findViewById<EditText>(R.id.activity_formulario_aluno_telefone)
		campoEmail = findViewById<EditText>(R.id.activity_formulario_aluno_email)
	}

	private fun salva(aluno: Aluno)
	{
		dao.salva(aluno)
		finish()
	}

	private fun criaAluno(): Aluno
	{
		val nome = campoNome?.text.toString()
		val telefone = campoTelefone?.text.toString()
		val email = campoEmail?.text.toString()

		return Aluno(nome, telefone, email)
	}
}