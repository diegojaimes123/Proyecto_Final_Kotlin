package com.example.tienda_sena.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.tienda_sena.ui.theme.DashBoard_v1Theme


@Composable
fun MainPage() {
    val navController = rememberNavController()
    // scaffoldState: guarada el estado
    val scaffoldState = rememberScaffoldState()
    //scope utilizada para abrir y cerrar el menu lateral
    val scope = rememberCoroutineScope()
    //opciones de navegación de Drawer
    val navigationItems = listOf(
        MenuItem.Page01,
        MenuItem.Page02,
        MenuItem.Page03,
        MenuItem.Page04,
        MenuItem.Page05,
        MenuItem.Page06
    )
    //opciones de navegación de BottomBar
    val navigationItemsBottomBar = listOf(
        Items_Bar.Boton1,
        Items_Bar.Boton2,
        Items_Bar.Boton3
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                scope,
                scaffoldState,
                navController,
                navigationItems
            )
        },
        drawerContent = {
            DrawerMenu(
                scope,
                scaffoldState,
                navController,
                menu_items = navigationItems,
            )
        },
        bottomBar = {
            BottomMenu(
                navController,
                menu_items_bar = navigationItemsBottomBar
            )
        },
        floatingActionButton = {
            Fab(scope,
                scaffoldState
            )
        },
        isFloatingActionButtonDocked = true
    )
    { padding ->
        ContentScaffold(
            padding  = padding
        )
        Navigation_Host(navController)
    }
}

@Composable
fun ContentScaffold(padding: PaddingValues) {

}

@Preview
@Composable
fun MainPagePreview() {
    DashBoard_v1Theme {
        MainPage()
    }
}