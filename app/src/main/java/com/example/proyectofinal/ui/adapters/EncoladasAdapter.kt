package com.example.proyectofinal.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.example.proyectofinal.app.PeliculaApplication
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.ui.send.ResenaFragment
import com.squareup.picasso.Picasso

class EncoladasAdapter(val peliculasEncoladas: MutableList<Pelicula>) : RecyclerView.Adapter<EncoladasAdapter.EncoladaViewHolder>(){

    inner class EncoladaViewHolder(vista: View) : RecyclerView.ViewHolder(vista){
        val fondo = vista.findViewById<ImageView>(R.id.fondoEncolada)
        val titulo = vista.findViewById<TextView>(R.id.tituloEncolada)
        val borrar = vista.findViewById<ImageView>(R.id.borrarEncolada)

        init {
            fondo.setOnClickListener { resenar(vista) }
            titulo.setOnClickListener { resenar(vista) }
        }

        private fun resenar(vista: View){
            val posicion = adapterPosition
            val pelicula = peliculasEncoladas.get(posicion)
            val resenaFragment = ResenaFragment.nuevaInstancia(pelicula)
            val contexto = vista.context as AppCompatActivity
            resenaFragment.show(contexto.supportFragmentManager, "ENCOLADAS_ADAPTER")
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EncoladaViewHolder {
        return EncoladaViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_encolada, parent, false))    }

    override fun getItemCount(): Int {
        return peliculasEncoladas.size
    }

    override fun onBindViewHolder(
        holder: EncoladaViewHolder,
        position: Int
    ) {
        val pelicula = peliculasEncoladas[position]
        val configuracion = PeliculaApplication.peliculaAPIConfiguration
        Picasso.get().load(configuracion?.images!!.secure_base_url + configuracion.images.backdrop_sizes.get(0) + pelicula.backdrop_path).into(holder.fondo)
        holder.titulo.text = pelicula.original_title
    }

    fun actualizarEncoladas(listaNueva: List<Pelicula>){
        peliculasEncoladas.clear()
        peliculasEncoladas.addAll(listaNueva)
        notifyDataSetChanged()
    }
}