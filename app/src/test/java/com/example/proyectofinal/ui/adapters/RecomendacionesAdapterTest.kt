package com.example.proyectofinal.ui.adapters

import com.example.proyectofinal.model.Pelicula
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RecomendacionesAdapterTest {

    @Mock
    val recomendaciones =
        mutableListOf(
            Pelicula(
                151.357f,
                "/b5XfICAvUe8beWExBz97i0Qw4Qh.jpg",
                612706,
                false,
                "/ishzDCZIv9iWfI70nv5E4ZreYUD.jpg",
                "Work It",
                "A brilliant but clumsy high school senior vows to get into her late father's alma mater by transforming herself and a misfit squad into dance champions."))

    @Test
    fun modeloRecomendacionesTest(){
        val recomendacionesAdapter = RecomendacionesAdapter(recomendaciones)
        Assert.assertEquals(recomendaciones, recomendacionesAdapter.recomendaciones)
    }
}