package com.example.proyectofinal.model.rest.retrofit.apis

import com.example.proyectofinal.apiKeyTheMovieDBdotOrg
import com.example.proyectofinal.model.PeliculaAPIConfiguration
import com.example.proyectofinal.model.RespuestaPelicula
import retrofit2.Call
import retrofit2.http.GET

interface PeliculaApi {

    @GET("3/discover/movie?api_key=$apiKeyTheMovieDBdotOrg")
    fun getRecomendaciones(): Call<RespuestaPelicula>

    @GET("3/configuration?api_key=$apiKeyTheMovieDBdotOrg")
    fun getConfiguracion(): Call<PeliculaAPIConfiguration>
}