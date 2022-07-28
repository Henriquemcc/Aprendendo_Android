package io.github.henriquemcc.agenda.kotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
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
	private var aluno = Aluno()

	@RequiresApi(33)
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_formulario_aluno)
		title = TITULO_APPBAR
		inicializacaoDosCampos()
		configuraBotaoSalvar()

		val dados = intent

		if (dados.hasExtra("aluno")) {
			if (dados.getSerializableExtra("aluno", Aluno::class.java) != null)
			{
				aluno = dados.getSerializableExtra("aluno", Aluno::class.java)!!
			}
			campoNome?.setText(aluno.nome)
			campoEmail?.setText(aluno.email)
			campoTelefone?.setText(aluno.telefone)
		}
	}

	private fun configuraBotaoSalvar()
	{
		val botaoSalvar = findViewById<Button>(R.id.activity_formulario_aluno_botao_salvar)
		botaoSalvar.setOnClickListener(object : View.OnClickListener
		{
			override fun onClick(p0: View?)
			{
				preencheAluno()
				if (aluno.temIdValido()) {
					dao.edita(aluno)
				}
				else {
					dao.salva(aluno)
				}
				finish()
			}
		})
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