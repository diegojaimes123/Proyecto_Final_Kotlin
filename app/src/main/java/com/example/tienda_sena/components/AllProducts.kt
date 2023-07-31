package com.example.tienda_sena.components


import com.example.tienda_sena.R

sealed class AllProducts(
    val name: String,
    val image: Int,
    val precio: String,
    val descipcion: String,
) {
    object Producto1 : AllProducts("Flores", R.drawable.ic_flores, "3.000", "describe de flores ")
    object Producto2 : AllProducts("Lirios", R.drawable.lirios, "2.500", "describe de lirios")
    object Producto3 : AllProducts("Rosas", R.drawable.rosas, "4.000", "describe de lirios")
    object Producto4: AllProducts("Huevos", R.drawable.ic_huevos, "14.000", "describe de huevos ")
    object Producto5: AllProducts("Huevos AA", R.drawable.huevosa, "12.000", "describe de huevos A")
    object Producto6: AllProducts("Huevos", R.drawable.huevosaa, "16.000", "describe de huevos AA")
    object Producto7 : AllProducts("Leche", R.drawable.leche, "1.000", "describe de leche ")
    object Producto8 : AllProducts("Yogurt", R.drawable.yogurt, "9.800", "describe de yogurt")
    object Producto9 : AllProducts("Leche de Cabra", R.drawable.ic_lacteos, "2.500", "describe de LEche de cabra")
}
