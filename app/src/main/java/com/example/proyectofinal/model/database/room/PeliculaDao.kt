package com.example.proyectofinal.model.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.model.database.room.entidades.PeliculaEntidad

@Dao
interface PeliculaDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarPelicula(peliculaEntidad: PeliculaEntidad)

    @Query("SELECT * FROM peliculas WHERE estrellasResenada IS NULL")
    fun getEncoladas(): LiveData<List<Pelicula>>

    @Query("SELECT * FROM peliculas WHERE estrellasResenada IS NOT NULL")
    fun getResenadas(): LiveData<List<Pelicula>>

    @Delete
    suspend fun borrarEncolada(peliculaEntidad: PeliculaEntidad)

    @Query("DELETE FROM peliculas WHERE estrellasResenada IS NULL")
    suspend fun borrarEncoladasTodas()
}