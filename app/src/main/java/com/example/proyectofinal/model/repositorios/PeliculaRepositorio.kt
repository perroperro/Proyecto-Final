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

    val peliculasEncoladasTodas: LiveData<List<Pelicula>> = peliculaDao.getEncoladas()

    suspend fun guardarPelicula(pelicula: Pelicula){
        val peliculaEntidad = PeliculaEntidadMapper.mapearDePeliculaAEntidad(pelicula)
        withContext(Dispatchers.IO){ peliculaDao.guardarPelicula(peliculaEntidad) }
    }

    suspend fun borrarPeliculaEncolada(peliculaEncolada: Pelicula){
        val peliculaEntidad = PeliculaEntidadMapper.mapearDePeliculaAEntidad(peliculaEncolada)
        withContext(Dispatchers.IO){ peliculaDao.borrarEncolada(peliculaEntidad) }
    }

    suspend fun borrarPeliculasEncoladas(){
        withContext(Dispatchers.IO){ peliculaDao.borrarEncoladasTodas() }
    }
}