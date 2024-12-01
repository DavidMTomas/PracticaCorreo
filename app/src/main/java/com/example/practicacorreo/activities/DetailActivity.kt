package com.example.practicacorreo.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.practicacorreo.R
import com.example.practicacorreo.databinding.ActivityDetailBinding
import com.example.practicacorreo.fragments.DetailFragment

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val texto=intent.getStringExtra("detalle")

        val fragment=DetailFragment.newInstance(texto.toString())
        val enviar=supportFragmentManager.beginTransaction()
        enviar.replace(R.id.fragContainerDetail,fragment)
        enviar.commitNow()


    }
}