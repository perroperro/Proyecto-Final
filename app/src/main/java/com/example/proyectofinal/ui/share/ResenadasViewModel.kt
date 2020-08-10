package com.example.proyectofinal.ui.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.model.Pelicula

class ResenadasViewModel : ViewModel() {

    private val _listaResenadas = MutableLiveData<List<Pelicula>>().apply {
        /*Por mientras*/value = listOf(Pelicula(1f, "perrito.com", 1, true, "/tIG8FwHRiHLOlWJdizp2oxdkSL2.jpg", "El Gato Que Quiso Morder Al Perro Pero Éste Le Dijo Conmigo No Y Le Pegó Un Patazo 3", "Mala", 3f, ""),
        Pelicula(2f, "gatito.com", 2, false, "/3H1yUIL1KxIuIMRwNMSL9cvifby.jpg", "El Perro Fantástico", "Uena", 0f, "Estupenda"))
    }

    val listaResenadas: LiveData<List<Pelicula>> = _listaResenadas

    fun postListaResenadas(listaRecomendaciones: List<Pelicula>){
        _listaResenadas.postValue(listaRecomendaciones)
    }
}