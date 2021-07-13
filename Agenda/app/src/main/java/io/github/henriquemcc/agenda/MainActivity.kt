package io.github.henriquemcc.agenda

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alunos = arrayListOf("Alex", "José", "Fran")
        val primeiroAluno = findViewById<TextView>(R.id.textView)
        val segundoAluno = findViewById<TextView>(R.id.textView2)
        val terceiroAluno = findViewById<TextView>(R.id.textView3)
        primeiroAluno.text = alunos[0]
        segundoAluno.text = alunos[1]
        terceiroAluno.text = alunos[2]
    }

}