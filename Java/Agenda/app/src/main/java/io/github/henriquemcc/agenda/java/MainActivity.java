package io.github.henriquemcc.agenda.java;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lista de alunos
        final List<String> alunos = Arrays.asList("João", "José", "Maria");

        // Adicionando string dos alunos aos text views
        final TextView primeiroAluno = findViewById(R.id.textView0);
        primeiroAluno.setText(alunos.get(0));
        final TextView segundoAluno = findViewById(R.id.textView1);
        segundoAluno.setText(alunos.get(1));
        final TextView terceiroAluno = findViewById(R.id.textView2);
        terceiroAluno.setText(alunos.get(2));
    }
}
