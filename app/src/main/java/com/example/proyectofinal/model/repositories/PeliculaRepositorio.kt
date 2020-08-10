package com.example.proyectofinal.model.repositories

import com.example.proyectofinal.app.PeliculaApplication
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.model.PeliculaEntidadMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PeliculaRepositorio {

    private val peliculaDao = PeliculaApplication.baseDatos.peliculaDao()

    val peliculasEncoladasTodas = peliculaDao.peliculasEncoladasTodas()

    suspend fun encolarPelicula(pelicula: Pelicula){
        val peliculaEntidad = PeliculaEntidadMapper.mapearDePeliculaAEntidad(pelicula)
        withContext(Dispatchers.IO){ peliculaDao.encolarPelicula(peliculaEntidad) }
    }
}