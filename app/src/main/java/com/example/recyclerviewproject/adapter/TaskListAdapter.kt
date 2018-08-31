package com.example.recyclerviewproject.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewproject.model.Task

class TaskListAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // Retorna a quantidade de itens na lista para o adapter
    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Nested Class (Classe aninhada)
     * A mesma somente será utilizada para o Adapter TaskListAdapter
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}