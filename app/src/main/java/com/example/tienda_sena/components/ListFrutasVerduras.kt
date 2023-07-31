package com.example.dashboard_v1.components

import com.example.tienda_sena.R

sealed class ListFrutasVerduras(
    val name: String,
    val image: Int,
    val precio: String,
    val descipcion: String,
) {
    object FruVer01: ListFrutasVerduras("Frutas y Verduras", R.drawable.ic_frutas_verduras, "2.000", "describe de Frutas y verduras ")
    object FruVer02: ListFrutasVerduras("Fresas", R.drawable.fresas, "2.000", "describe de fresas ")
    object FruVer03: ListFrutasVerduras("Lechuga", R.drawable.lechuga, "2.000", "describe de Lechuga ")
    object FruVer04: ListFrutasVerduras("Moras", R.drawable.moras, "2.000", "describe de Moras ")



}