package com.example.proyectofinal.ui.home

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.example.proyectofinal.model.RespuestaPelicula
import com.example.proyectofinal.model.rest.retrofit.ClienteRetrofit
import com.example.proyectofinal.ui.adapters.RecomendacionesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecomendacionesFragment : Fragment() {

    private lateinit var recomendacionesViewModel: RecomendacionesViewModel
    private var recomendacionesAdapter = RecomendacionesAdapter(mutableListOf())
    private lateinit var contexto: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contexto = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recomendacionesViewModel =
            ViewModelProvider(this).get(RecomendacionesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recomendaciones, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recyclerRecomendaciones)

        recomendacionesViewModel.listaRecomendaciones.observe(this, Observer {
            recomendacionesAdapter.actualizarRecomendaciones(it)
            recyclerView.adapter = recomendacionesAdapter
        })

//Por mientras:
        ClienteRetrofit.instanciaRetrofit().getRecomendaciones().enqueue(object:
            Callback<RespuestaPelicula> {
            override fun onFailure(call: Call<RespuestaPelicula>, t: Throwable) {
                AlertDialog.Builder(contexto)
                    .setMessage("No se pudo establecer conexión.")
                    .setPositiveButton("Aceptar"){
                            dialog: DialogInterface, _: Int ->
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            }

            override fun onResponse(
                call: Call<RespuestaPelicula>,
                response: Response<RespuestaPelicula>
            ) {
                val respuestaPeliculas = response.body()
                if(respuestaPeliculas != null){
                    recomendacionesViewModel.postListaRecomendaciones(respuestaPeliculas.results)
                }
            }
        })

        return root
    }
}