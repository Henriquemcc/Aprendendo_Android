package io.github.henriquemcc.agenda.java.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import io.github.henriquemcc.agenda.java.R;

public class ListaAlunosActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        setTitle("Lista de alunos");

        // Lista de alunos
        final List<String> alunos = Arrays.asList("João", "José", "Maria", "Carlos", "Gabriel", "Ana");

        // List View com os alunos
        final ListView listViewListaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);

        // Adicionando adaptador com uma lista simples de itens
        listViewListaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));
    }
}
