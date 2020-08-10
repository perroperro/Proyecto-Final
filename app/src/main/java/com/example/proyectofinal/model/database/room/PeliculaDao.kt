package com.example.proyectofinal.model.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.proyectofinal.model.database.room.entidades.PeliculaEntidad

@Dao
interface PeliculaDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun encolarPelicula(peliculaEntidad: PeliculaEntidad)
}