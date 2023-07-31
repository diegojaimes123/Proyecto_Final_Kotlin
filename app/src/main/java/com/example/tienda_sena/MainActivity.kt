package com.example.tienda_sena

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tienda_sena.ui.theme.DashBoard_v1Theme
import com.example.tienda_sena.comp_login.TiendaApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DashBoard_v1Theme {
            TiendaApp()
            }
        }
    }
}