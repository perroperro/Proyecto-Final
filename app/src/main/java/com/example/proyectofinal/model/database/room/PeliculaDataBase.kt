package com.example.proyectofinal.model.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.model.database.room.entidades.PeliculaEntidad

@Database(entities = [PeliculaEntidad::class], version = 1)
abstract class PeliculaDataBase : RoomDatabase() {

    abstract fun peliculaDao(): PeliculaDao

    companion object {

        @Volatile
        private var INSTANCE: PeliculaDataBase? = null

        fun getPeliculaDatabase(context: Context): PeliculaDataBase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PeliculaDataBase::class.java,
                    "peliculas_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}