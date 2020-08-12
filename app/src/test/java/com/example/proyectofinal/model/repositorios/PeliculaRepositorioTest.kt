package com.example.proyectofinal.model.repositorios

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.proyectofinal.app.PeliculaApplication
import com.example.proyectofinal.model.Pelicula
import com.example.proyectofinal.model.database.room.PeliculaDao
import com.example.proyectofinal.model.database.room.PeliculaDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

class PeliculaRepositorioTest {

}