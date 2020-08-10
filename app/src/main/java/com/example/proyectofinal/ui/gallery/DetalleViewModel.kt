package com.example.proyectofinal.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.model.repositories.PeliculaRepositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetalleViewModel : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = Dispatchers.Main + job

    private val peliculaRepositorio = PeliculaRepositorio()

    val _peliculaDetallada = MutableLiveData<Pelicula>()

    val peliculaDetallada: LiveData<Pelicula> = _peliculaDetallada

    fun encolarPelicula(pelicula: Pelicula){
        launch {
            peliculaRepositorio.encolarPelicula(pelicula)
        }
    }
}