package com.example.practicacorreo.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicacorreo.R
import com.example.practicacorreo.adapters.Evento
import com.example.practicacorreo.databinding.ActivityMainBinding
import com.example.practicacorreo.fragments.DetailFragment
import com.example.practicacorreo.pojos.Correo

class MainActivity : AppCompatActivity(), Evento {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



    override fun enviarEvento(correo: Correo) {
        Toast.makeText(this,"Pulsado ${correo.de}", Toast.LENGTH_LONG).show()
        if(correo!=null){
            var detalle=supportFragmentManager.findFragmentById(R.id.fragContainerDetail)

            // si existe detalle lanzalo en la misma actividad
            if(detalle!=null){
                val fragment=DetailFragment.newInstance(correo.texto)
                val envio=supportFragmentManager.beginTransaction()
                envio.replace(R.id.fragContainerDetail,fragment)
                envio.commitNow()
            // si no existe detalle, lanza una nueva actividad
            }else{
                var intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("detalle",correo.texto)
                startActivity(intent)
        }
        }


    }
}