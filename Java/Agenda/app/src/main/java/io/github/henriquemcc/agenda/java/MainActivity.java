package io.github.henriquemcc.agenda.java;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista de alunos");

        // Lista de alunos
        final List<String> alunos = Arrays.asList("João", "José", "Maria", "Carlos", "Gabriel", "Ana");

        // List View com os alunos
        final ListView listViewListaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);

        // Adicionando adaptador com uma lista simples de itens
        listViewListaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));
    }
}
