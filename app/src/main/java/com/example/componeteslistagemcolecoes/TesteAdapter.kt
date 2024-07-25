package com.example.componeteslistagemcolecoes

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.componeteslistagemcolecoes.databinding.ItemCardviewBinding

class TesteAdapter: Adapter<TesteAdapter.MensagemViewHolder> (){

    inner class MensagemViewHolder(val binding: ItemCardviewBinding) : ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MensagemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}