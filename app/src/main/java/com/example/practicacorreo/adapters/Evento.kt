package com.example.practicacorreo.adapters

import com.example.practicacorreo.pojos.Correo

interface Evento {
fun enviarEvento(correo: Correo)
}
