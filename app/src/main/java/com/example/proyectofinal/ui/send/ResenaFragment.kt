package com.example.proyectofinal.ui.send

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.proyectofinal.R
import com.example.proyectofinal.model.Pelicula
import kotlinx.android.synthetic.main.fragment_resena.*
import kotlinx.android.synthetic.main.fragment_resena.view.*

class ResenaFragment : DialogFragment() {

    private lateinit var resenaViewModel: ResenaViewModel

    companion object {
        fun nuevaInstancia(pelicula: Pelicula): ResenaFragment {
            val fragmento = ResenaFragment()
            val argumentos = Bundle()
            argumentos.putSerializable("PELICULA", pelicula)
            fragmento.arguments = argumentos
            return fragmento
        }
    }

        override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        resenaViewModel =
            ViewModelProvider(this).get(ResenaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_resena, container, false)

        if(resenaViewModel.peliculaResena.value == null){
            val pelicula = arguments!!.getSerializable("PELICULA") as Pelicula
            resenaViewModel._peliculaResena.postValue(pelicula)
        }

        resenaViewModel.peliculaResena.observe(this, Observer {
            tituloResenada.text = it.original_title
            estrellas.rating = it.estrellas?:0f
            resena.setText(it.resena)
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resenar.setOnClickListener {
            val pelicula = arguments!!.getSerializable("PELICULA") as Pelicula
            pelicula.estrellas = view.estrellas.rating
            pelicula.resena = view.resena.text.toString()
            resenaViewModel.resenarPelicula(pelicula)
        }

        cancelar.setOnClickListener { dismiss() }
    }
}