package com.example.proyectofinal.model.repositorios

import androidx.lifecycle.LiveData
import com.example.proyectofinal.app.PeliculaApplication
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.model.PeliculaEntidadMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PeliculaRepositorio {

    private val peliculaDao = PeliculaApplication.baseDatos.peliculaDao()

    val peliculasResenadasTodas: LiveData<List<Pelicula>> = peliculaDao.getResenadas()

    suspend fun guardarPelicula(pelicula: Pelicula){
        val peliculaEntidad = PeliculaEntidadMapper.mapearDePeliculaAEntidad(pelicula)
        withContext(Dispatchers.IO){ peliculaDao.guardarPelicula(peliculaEntidad) }
    }
}