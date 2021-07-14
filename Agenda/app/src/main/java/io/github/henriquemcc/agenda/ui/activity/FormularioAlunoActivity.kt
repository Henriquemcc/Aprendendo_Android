package io.github.henriquemcc.agenda.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import io.github.henriquemcc.agenda.R
import io.github.henriquemcc.agenda.dao.AlunoDataAccessObject
import io.github.henriquemcc.agenda.model.Aluno

class FormularioAlunoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_aluno)
        title = "Novo aluno"

        val dataAccessObjectAluno = AlunoDataAccessObject()

        val campoNome = findViewById<EditText>(R.id.activity_formulario_aluno_nome)
        val campoTelefone = findViewById<EditText>(R.id.activity_formulario_aluno_telefone)
        val campoEmail = findViewById<EditText>(R.id.activity_formulario_aluno_email)

        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_aluno_botao_salvar)
        botaoSalvar.setOnClickListener {
            val nome = campoNome.text.toString()
            val telefone = campoTelefone.text.toString()
            val email = campoEmail.text.toString()

            val alunoCriado = Aluno(nome, telefone, email)
            dataAccessObjectAluno.salvar(alunoCriado)

            finish()
        }
    }
}