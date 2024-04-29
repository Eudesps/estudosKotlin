package com.example.componeteslistagemcolecoes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MensagemAdapter(
    private val lista: List<Mensagem>
): Adapter<MensagemAdapter.MensagemViweHolder>() {
   // MensagemViweHolder - é a classe que vai armezenar a visualização
    inner class MensagemViweHolder(val itemview: View): ViewHolder(itemview){
       /* val textNome: TextView = itemview.findViewById(R.id.text_nome)
        val textUtima: TextView = itemview.findViewById(R.id.text_ultima)
        val textHorario: TextView = itemview.findViewById(R.id.text_horario)*/

       val textNome: TextView = itemview.findViewById(R.id.text_card_nome)
       val textUtima: TextView = itemview.findViewById(R.id.text_card_ultima)
    }

    //Esse método vai criar a visualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViweHolder {
       val layoutInflater = LayoutInflater.from(
           parent.context
       )
       /*val itemview = layoutInflater.inflate(
            R.layout.item_lista,parent,false
       )*/
        val itemview = layoutInflater.inflate(
            R.layout.item_cardview,parent,false
        )
        return MensagemViweHolder(itemview)
    }

    //getItemCount - Recupera a quantidade de itens, ele vai contar a quantidade de itens
    override fun getItemCount(): Int =  lista.size

    //Ao vincular o ViewHolder - Aqui é possivel acessar os recursos da visualização
    override fun onBindViewHolder(holder: MensagemViweHolder, position: Int) {
        val mensagem = lista[position]
        holder.textNome.text = mensagem.nome
        holder.textUtima.text = mensagem.ultima
    }
}