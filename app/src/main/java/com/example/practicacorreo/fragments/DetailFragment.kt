package com.example.practicacorreo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicacorreo.R
import com.example.practicacorreo.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailBinding.inflate(inflater,container,false)
        val detalle=arguments?.getString("detalle")
        binding.tvDetalle.text=detalle
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(detalle: String):DetailFragment{
            val fragment=DetailFragment()
            val bundle=Bundle()
            bundle.putString("detalle",detalle)
            fragment.arguments=bundle
            return fragment
        }
    }
}