package com.example.practicacorreo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicacorreo.R
import com.example.practicacorreo.adapters.CorreoAdapter
import com.example.practicacorreo.adapters.Evento
import com.example.practicacorreo.databinding.FragmentListBinding
import com.example.practicacorreo.pojos.CorreoDatos


class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    lateinit var correoAdapter: CorreoAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var dividerItemDecoration: DividerItemDecoration


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentListBinding.inflate(inflater, container,false)
        var evento=requireActivity() as Evento

        correoAdapter=CorreoAdapter(CorreoDatos.CORREOS,evento)
        linearLayoutManager= LinearLayoutManager(context)
        dividerItemDecoration= DividerItemDecoration(context,DividerItemDecoration.VERTICAL)

        binding.rvListFragment.apply {
            adapter=correoAdapter
            layoutManager=linearLayoutManager
            addItemDecoration(dividerItemDecoration)
        }




        // Inflate the layout for this fragment
        return binding.root
    }


}