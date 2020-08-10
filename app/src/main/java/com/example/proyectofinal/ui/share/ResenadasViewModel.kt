package com.example.proyectofinal.ui.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.model.repositorios.PeliculaRepositorio

class ResenadasViewModel : ViewModel() {

    private val peliculaRepositorio = PeliculaRepositorio()

    val listaResenadas: LiveData<List<Pelicula>> = peliculaRepositorio.peliculasResenadasTodas
}