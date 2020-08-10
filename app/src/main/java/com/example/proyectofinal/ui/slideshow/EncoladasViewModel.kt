package com.example.proyectofinal.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectofinal.model.Pelicula

class EncoladasViewModel : ViewModel() {

    private val _listaEncoladas = MutableLiveData<List<Pelicula>>().apply {
        value = listOf(Pelicula(1f, "perrito.com", 1, true, "/tIG8FwHRiHLOlWJdizp2oxdkSL2.jpg", "El Gato Que Quiso Morder Al Perro Pero Éste Le Dijo Conmigo No Y Le Pegó Un Patazo 3", "Mala"),
            Pelicula(2f, "gatito.com", 2, false, "/3H1yUIL1KxIuIMRwNMSL9cvifby.jpg", "El Perro Fantástico", "Uena"))
    }
    val listaEncoladas: LiveData<List<Pelicula>> = _listaEncoladas
}