package com.example.proyectofinal.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.model.repositorios.PeliculaRepositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EncoladasViewModel : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private val peliculaRepositorio = PeliculaRepositorio()

    val listaEncoladas: LiveData<List<Pelicula>> = peliculaRepositorio.peliculasEncoladasTodas

    fun borrarEncolada(peliculaEncolada: Pelicula){
        launch {
            peliculaRepositorio.borrarPeliculaEncolada(peliculaEncolada)
        }
    }

    fun borrarTodasEncoladas(){
        launch {
            peliculaRepositorio.borrarPeliculasEncoladas()
        }
    }
}