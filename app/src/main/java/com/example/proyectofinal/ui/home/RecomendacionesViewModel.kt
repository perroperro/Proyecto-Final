package com.example.proyectofinal.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.model.Pelicula

class RecomendacionesViewModel : ViewModel() {

    private val _listaRecomendaciones = MutableLiveData<List<Pelicula>>()

    val listaRecomendaciones: LiveData<List<Pelicula>> = _listaRecomendaciones

    fun postListaRecomendaciones(listaRecomendaciones: List<Pelicula>){
        _listaRecomendaciones.postValue(listaRecomendaciones)
    }
}