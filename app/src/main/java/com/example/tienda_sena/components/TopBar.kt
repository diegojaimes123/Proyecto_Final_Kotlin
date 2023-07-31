package com.example.tienda_sena.components

import android.graphics.Color
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    menuItem: List<MenuItem>
) {
    var showMenu by remember {
        mutableStateOf(false)
    }
    val currentRoute = Current_Route(navController = navController)
    var mytyle = "Tienda Sena CBA"
    menuItem.forEach { item ->
        if (currentRoute == item.ruta) mytyle = item.title
    }
    TopAppBar(
        title = {Text(text = mytyle)},
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Icono de menú"
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Refresh,
                    contentDescription = "Refrescar"
                    )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Settings,
                    contentDescription = "Configurar"
                    )
            }
            IconButton(onClick = {showMenu = !showMenu}) {
                Icon(imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Más Opciones"
                )
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = {  showMenu = false},
                modifier = Modifier.width(150.dp)
                ) {

                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Idioma"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Idioma")
                }
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Compartir"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Compartir")
                }
            }
        }
    )
}






