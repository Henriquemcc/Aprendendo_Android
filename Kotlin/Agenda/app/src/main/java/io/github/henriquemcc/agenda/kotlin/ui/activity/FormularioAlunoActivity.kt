package io.github.henriquemcc.agenda.kotlin.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.github.henriquemcc.agenda.kotlin.R
import io.github.henriquemcc.agenda.kotlin.dao.AlunoDAO
import io.github.henriquemcc.agenda.kotlin.model.Aluno

class FormularioAlunoActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_formulario_aluno)

		val dao = AlunoDAO()

		val campoNome = findViewById<EditText>(R.id.activity_formulario_aluno_nome)
		val campoTelefone = findViewById<EditText>(R.id.activity_formulario_aluno_telefone)
		val campoEmail = findViewById<EditText>(R.id.activity_formulario_aluno_email)

		val botaoSalvar = findViewById<Button>(R.id.activity_formulario_aluno_botao_salvar)
		botaoSalvar.setOnClickListener(object : View.OnClickListener
		{
			override fun onClick(p0: View?)
			{
				val nome = campoNome.text.toString()
				val telefone = campoTelefone.text.toString()
				val email = campoEmail.text.toString()

				val alunoCriado = Aluno(nome, telefone, email)
				dao.salva(alunoCriado)

				finish()
			}
		})
	}
}