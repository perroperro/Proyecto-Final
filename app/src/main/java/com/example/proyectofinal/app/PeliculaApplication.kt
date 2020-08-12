package com.example.proyectofinal.app

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.proyectofinal.model.PeliculaAPIConfiguration
import com.example.proyectofinal.model.database.room.PeliculaDataBase
import com.example.proyectofinal.model.repositorios.PeliculaRepositorio
import com.example.proyectofinal.model.rest.retrofit.ClienteRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeliculaApplication : Application() {

    lateinit var peliculaRepositorio: PeliculaRepositorio

    companion object{
        var peliculaAPIConfiguration: PeliculaAPIConfiguration? = null
        lateinit var baseDatos: PeliculaDataBase
    }

    override fun onCreate() {
        super.onCreate()

        baseDatos = PeliculaDataBase.getPeliculaDatabase(this)
        peliculaRepositorio = PeliculaRepositorio(baseDatos.peliculaDao())

        peliculaRepositorio.configuracion.observeForever(Observer {
            peliculaAPIConfiguration = it
        })

        peliculaRepositorio.errorConexionConfiguracion.observeForever(Observer {
            Toast.makeText(this, "No se pudo desacargar el archivo de configuración. Las imágenes podrían no mostrarse.\n$it", Toast.LENGTH_LONG).show()
        })

        peliculaRepositorio.getConfiguracion()
    }
}