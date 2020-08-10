package com.example.proyectofinal.model.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.model.database.room.entidades.PeliculaEntidad

@Dao
interface PeliculaDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarPelicula(peliculaEntidad: PeliculaEntidad)

    @Query("SELECT * FROM peliculas WHERE estrellas IS NOT NULL")
    fun getResenadas(): LiveData<List<Pelicula>>
}