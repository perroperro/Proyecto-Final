package com.example.proyectofinal.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.example.proyectofinal.ui.adapters.EncoladasAdapter

class EncoladasFragment : Fragment() {

    private lateinit var encoladasViewModel: EncoladasViewModel
    private var encoladasAdapter = EncoladasAdapter(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        encoladasViewModel =
            ViewModelProvider(this).get(EncoladasViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_encoladas, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recyclerEncoladas)

        encoladasViewModel.listaEncoladas.observe(this, Observer {
            encoladasAdapter.actualizarEncoladas(it)
            recyclerView.adapter = encoladasAdapter
        })
        return root
    }
}