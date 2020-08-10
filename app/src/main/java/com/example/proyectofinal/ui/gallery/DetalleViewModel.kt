package com.example.proyectofinal.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.model.Pelicula

class DetalleViewModel : ViewModel() {

    val _peliculaDetallada = MutableLiveData<Pelicula>()

    val peliculaDetallada: LiveData<Pelicula> = _peliculaDetallada
}