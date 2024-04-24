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
    inner class MensagemViweHolder(
        val itemview: View
    ): ViewHolder(itemview){

        val textNome: TextView = itemview.findViewById(R.id.text_nome)
        val textUtima: TextView = itemview.findViewById(R.id.text_ultima)
        val textHorario: TextView = itemview.findViewById(R.id.text_horario)

    }

    //Esse método vai criar a visualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViweHolder {
       val layoutInflater = LayoutInflater.from(
           parent.context
       )
       val itemview = layoutInflater.inflate(
            R.layout.item_lista,parent,false
       )
        return MensagemViweHolder(itemview)
    }

    //getItemCount - Recupera a quantidade de itens, ele vai contar a quantidade de itens
    override fun getItemCount(): Int {
        return lista.size
    }

    //Ao vincular o ViewHolder -
    override fun onBindViewHolder(holder: MensagemViweHolder, position: Int) {
        val mensagem = lista[position]
        holder.textNome.text = mensagem.nome
        holder.textHorario.text = mensagem.horario
        holder.textUtima.text = mensagem.ultima
    }
}