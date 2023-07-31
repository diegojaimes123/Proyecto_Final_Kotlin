package com.example.tienda_sena.components


import com.example.tienda_sena.R

sealed class ListHuevos(
    val name: String,
    val image: Int,
    val precio: String,
    val descipcion: String,
){
    object Huevo01: ListHuevos("Huevos", R.drawable.ic_huevos, "14.000", "describe de huevos ")
    object Huevo02: ListHuevos("Huevos AA", R.drawable.huevosa, "12.000", "describe de huevos A")
    object Huevo03: ListHuevos("Huevos", R.drawable.huevosaa, "16.000", "describe de huevos AA")
}

