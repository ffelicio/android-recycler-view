package com.example.recyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewproject.adapter.TaskListAdapter
import com.example.recyclerviewproject.model.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = task_list_recyclerview
        recyclerView.adapter = TaskListAdapter(tasks(), this)

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }

    private fun tasks(): List<Task> {
        return listOf(
                Task("Aprender Kotlin", "Item para montar a lista de estudos da linguagem."),
                Task("Ciclo de Vida - Activity", "Estudos das referências dos métodos utilizados no aplicativo."),
                Task("Iniciando outra Activity", "Estudo das activities e passagem de valores entre as mesmas."),
                Task("Criar uma simples interface (EditText)", "Estudo para criação do layout e campos de texto editáveis."),
                Task("Criar uma interface com RecyclerView", "Estudo do RecyclerView e os componentes para criação, como Adapter e ViewHolder"),
                Task("Principais componentes - Material Design", "Estudos dos componentes de layout")
        )
    }
}