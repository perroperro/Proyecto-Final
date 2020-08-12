package com.example.proyectofinal.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.app.PeliculaApplication
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.model.repositorios.PeliculaRepositorio

class RecomendacionesViewModel : ViewModel() {

    private val peliculaRepositorio = PeliculaRepositorio(PeliculaApplication.baseDatos.peliculaDao())

    val listaRecomendaciones: LiveData<List<Pelicula>> = peliculaRepositorio.recomendaciones
    val noSeConecto: LiveData<String> = peliculaRepositorio.errorConexion

    fun getRecomendaciones(){
        peliculaRepositorio.getRecomendaciones()
    }
}