package com.example.recyclerviewproject.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewproject.R
import com.example.recyclerviewproject.model.Task
import kotlinx.android.synthetic.main.task_item.view.*

/*
 * No construtor da classe são passadas as referências pro Adapter.
 * 1º argumento - Lista de dados a serem percorridos
 * 2º argumento - Contexto de quem está utilizando o RecyclerView (o mesmo é passado na Activity)
 */
class TaskListAdapter(private val tasks: List<Task>, private val context: Context) : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {

    /**
     * Método responsável por inflar o layout.
     * No mesmo é retornada a instância do ViewHolder. Em seu argumento é passada a view a ser inflada.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false)
        return ViewHolder(view)
    }

    // Retorna o tamanho da lista de itens para o adapter
    override fun getItemCount() = tasks.size

    /*
     * Método responsável por juntar as informações contidas no ViewHolder com os componentes do layout
     *
     * O operador "?", durante a declaração de uma variável, parâmetro, property ou retorno de função, nos indica que existe uma possibilidade que o valor seja "null",
     * portanto, o Kotlin exige que a gente trate esse objeto e garanta que ele não seja "null" (Null Safety).
     * O Null Safety tem a proposta de evitar o "NullPointerException".
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Resgata o item da lista por meio da posição recebida para fazer o processo de bind (juntar as informações).
        val task = tasks[position]
        Log.d("onBindViewHolder", task.title)
        /*
         * Abordagem 1
         * ----------------------------------------------------------------------------------------------------------------------------------------------------
         * Vincula a informação do objeto com os textView's
         * ----------------------------------------------------------------------------------------------------------------------------------------------------
         * O operador "?" a frente da propriedade significa "Safe Call".
         * A partir dele temos a capacidade de garantir que um membro de um objeto (property, funções ou classes) vai ser chamado apenas se ele não for "null".
        holder?.title?.text = task.title
        holder?.description?.text = task.description
        */

        /*
         * Abordagem 2
         * --------------------------------------------------------------------------------------------------------------------------------------------------
         * Função let
         * --------------------------------------------------------------------------------------------------------------------------------------------------
         * A mesma pode ser chamada a partir de um objeto (como é o caso do holder), e então executa um bloco de função com o objeto que a chamou embutido
         * dentro dela.
         * Quando foi feito a "Safe Call" e chamamos o "let" com o nosso holder, o nosso holder foi para dentro do escopo do "let" como um objeto que não é null.
         * Portanto, ao utilizá-lo dentro do escopo do "let", não existe mais a necessidade de verificar se ele ou seus membros são "null".
        holder?.let {
            // Quando utilizamos o "let", o objeto enviado pode ser chamado utilizando a keyword "it". Ela é o próprio objeto embutido dentro do "let".
            // holder.title.text = task.title
            // holder.description.text = task.description
            it.title.text = task.title
            it.description.text = task.description
        }
        */

        /*
         * Abordagem 3
         * --------------------------------------------------------------------------------------------------------------------------------------------------
         * Chamando o método da ViewHolder.
         * A responsabilidade de vínculo das informações do objeto, foi removida do método "onBindViewHolder" e foi transferida a própria classe "ViewHolder".
         */
        holder.bindView(task)
    }

    /*
     * Nested Class (Classe aninhada)
     * A mesma somente será utilizada para o Adapter TaskListAdapter
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*
         * Delega a responsabilidade de vínculo dos itens de layout às referências do objeto
         */
        fun bindView(task: Task) {
            val title = itemView.textViewTitle
            val description = itemView.textViewDescription

            title.text = task.title
            description.text = task.description
        }
    }
}