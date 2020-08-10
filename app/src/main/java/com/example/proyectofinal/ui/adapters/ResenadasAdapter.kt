package com.example.proyectofinal.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.example.proyectofinal.app.PeliculaApplication
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.ui.send.ResenaFragment
import com.squareup.picasso.Picasso

class ResenadasAdapter(val peliculasResenadas: MutableList<Pelicula>) : RecyclerView.Adapter<ResenadasAdapter.ResenadaViewHolder>(){

    inner class ResenadaViewHolder(vista: View) : RecyclerView.ViewHolder(vista){
        val fondo = vista.findViewById<ImageView>(R.id.fondoResenada)
        val titulo = vista.findViewById<TextView>(R.id.tituloResenada)
        val estrellas = vista.findViewById<RatingBar>(R.id.estrellasResenada)

        init {
            vista.setOnClickListener {
                val posicion = adapterPosition
                val pelicula = peliculasResenadas.get(posicion)
                val resenaFragment = ResenaFragment.nuevaInstancia(pelicula)
                val contexto = vista.context as AppCompatActivity
                resenaFragment.show(contexto.supportFragmentManager, "RESENAS_ADAPTER")

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResenadaViewHolder {
        return ResenadaViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_resenada, parent, false))    }

    override fun getItemCount(): Int {
        return peliculasResenadas.size
    }

    override fun onBindViewHolder(
        holder: ResenadaViewHolder,
        position: Int
    ) {
        val pelicula = peliculasResenadas[position]
        val configuracion = PeliculaApplication.peliculaAPIConfiguration
        Picasso.get().load(configuracion?.images!!.secure_base_url + configuracion.images.backdrop_sizes.get(0) + pelicula.backdrop_path).into(holder.fondo)
        holder.titulo.text = pelicula.original_title
        holder.estrellas.rating = pelicula.estrellas!!}

    fun actualizarResenadas(listaNueva: List<Pelicula>){
        peliculasResenadas.clear()
        peliculasResenadas.addAll(listaNueva)
        notifyDataSetChanged()
    }
}