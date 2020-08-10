package com.example.proyectofinal.app

import android.app.Application
import com.example.proyectofinal.model.PeliculaAPIConfiguration
import com.example.proyectofinal.model.rest.retrofit.ClienteRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeliculaApplication : Application() {

    companion object{
        var peliculaAPIConfiguration: PeliculaAPIConfiguration? = null
    }

    override fun onCreate() {
        super.onCreate()

        //Cambiar a Repositorio
        ClienteRetrofit.instanciaRetrofit().getConfiguracion().enqueue(object:
            Callback<PeliculaAPIConfiguration> {
            override fun onFailure(call: Call<PeliculaAPIConfiguration>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<PeliculaAPIConfiguration>,
                response: Response<PeliculaAPIConfiguration>
            ) {
                peliculaAPIConfiguration = response.body()
            }
        })
    }
}