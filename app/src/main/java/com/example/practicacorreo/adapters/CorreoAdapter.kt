package com.example.practicacorreo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicacorreo.R
import com.example.practicacorreo.databinding.ItemListBinding
import com.example.practicacorreo.pojos.Correo

class CorreoAdapter(val lista: List<Correo>, var evento: Evento) :
    RecyclerView.Adapter<CorreoAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemListBinding.bind(view)

        fun render(correo: Correo) {
            binding.tvDe.text = correo.de
            binding.tvAsunto.text = correo.asunto
            setEvento(correo)
        }

        private fun setEvento(correo: Correo) {
            binding.root.setOnClickListener {
                evento.enviarEvento(correo)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(lista[position])
    }
}