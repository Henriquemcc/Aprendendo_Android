package io.github.henriquemcc.agenda.kotlin

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity: Activity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alunos = listOf<String>("João", "José", "Maria")
        val primeiroAluno = findViewById<TextView>(R.id.textView0)
        primeiroAluno.text = alunos[0]
        val segundoAluno = findViewById<TextView>(R.id.textView1)
        segundoAluno.text = alunos[1]
        val terceiroAluno = findViewById<TextView>(R.id.textView2)
        terceiroAluno.text = alunos[2]
    }
}