package io.github.henriquemcc.agenda.java.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

import io.github.henriquemcc.agenda.java.R;
import io.github.henriquemcc.agenda.java.dao.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        final AlunoDAO dao = new AlunoDAO();

        setTitle("Lista de alunos");

        final ListView listViewListaDeAlunos = findViewById(R.id.activity_lista_alunos_listview);
        listViewListaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}
