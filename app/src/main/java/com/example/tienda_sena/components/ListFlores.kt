package com.example.tienda_sena.components

import com.example.tienda_sena.R

sealed class ListFlores(
    val name: String,
    val image: Int,
    val precio: String,
    val descipcion: String,
)
{
    object Flor01 : ListFlores("Flores", R.drawable.ic_flores, "3.000", " son aquellas que producen semillas y tienen en las flores ")
    object Flor02 : ListFlores("Lirios", R.drawable.lirios, "2.500", "describe de lirios")
    object Flor03 : ListFlores("Rosas", R.drawable.rosas, "4.500", "describe de rosas")
}
