package com.example.tienda_sena.components

import com.example.tienda_sena.R

sealed class ListLacteos(
    val name: String,
    val image: Int,
    val precio: String,
    val descipcion: String,
) {
    object Lacteo01 : ListLacteos("Leche", R.drawable.leche, "1.000", "describe de leche ")
    object Lacteo02 : ListLacteos("Yogurt", R.drawable.yogurt, "9.800", "describe de yogurt")
    object Lacteo03 : ListLacteos("Leche de Cabra", R.drawable.ic_lacteos, "2.500", "describe de LEche de cabra")

}
