package com.example.proyectofinal.ui.send

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.model.Pelicula

class ResenaViewModel : ViewModel() {

    val _peliculaResena = MutableLiveData<Pelicula>()

    val peliculaResena: LiveData<Pelicula> = _peliculaResena
}