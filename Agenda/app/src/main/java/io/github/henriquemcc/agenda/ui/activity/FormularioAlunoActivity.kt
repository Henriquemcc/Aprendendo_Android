package io.github.henriquemcc.agenda.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import io.github.henriquemcc.agenda.R
import io.github.henriquemcc.agenda.dao.AlunoDataAccessObject
import io.github.henriquemcc.agenda.model.Aluno

class FormularioAlunoActivity : AppCompatActivity() {

    private val campoNome: EditText
        get() = findViewById(R.id.activity_formulario_aluno_nome)

    private val campoTelefone: EditText
        get() = findViewById(R.id.activity_formulario_aluno_telefone)

    private val campoEmail: EditText
        get() = findViewById(R.id.activity_formulario_aluno_email)

    private val dataAccessObjectAluno = AlunoDataAccessObject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_aluno)
        title = "Novo aluno"
        configurarBotaoSalvar()
    }

    private fun configurarBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_aluno_botao_salvar)
        botaoSalvar.setOnClickListener {
            val alunoCriado = criarAluno()
            salvar(alunoCriado)
        }
    }

    private fun salvar(alunoCriado: Aluno) {
        dataAccessObjectAluno.salvar(alunoCriado)
        finish()
    }

    private fun criarAluno(): Aluno {
        val nome = campoNome.text.toString()
        val telefone = campoTelefone.text.toString()
        val email = campoEmail.text.toString()

        return Aluno(nome, telefone, email)
    }
}