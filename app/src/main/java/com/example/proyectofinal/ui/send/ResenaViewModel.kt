package com.example.proyectofinal.ui.send

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.model.repositorios.PeliculaRepositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ResenaViewModel : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private val peliculaRepositorio = PeliculaRepositorio()

    val _peliculaResena = MutableLiveData<Pelicula>()

    val peliculaResena: LiveData<Pelicula> = _peliculaResena

    fun resenarPelicula(pelicula: Pelicula){
        launch {
            peliculaRepositorio.guardarPelicula(pelicula)
        }
    }
}