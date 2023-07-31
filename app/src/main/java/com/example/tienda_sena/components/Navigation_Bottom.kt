package com.example.tienda_sena.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tienda_sena.ui.theme.SenaGreen
import com.example.tienda_sena.ui.theme.SenaGreenClaro

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun BottomMenu(
    navController: NavHostController,
    menu_items_bar: List<Items_Bar>
){
    BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
        backgroundColor = SenaGreen
    ) {
        BottomNavigation(
            modifier = Modifier
                .padding(
                0.dp,
                0.dp,
                60.dp,
                0.dp
            ),
            backgroundColor = SenaGreen
        ) {
            val currentRouteBar = Current_Route(navController = navController)
            menu_items_bar.forEach { item ->
                BottomNavigationItem(
                    selected = currentRouteBar == item.ruta,
                    onClick = { navController.navigate(item.ruta) },
                    icon = {
                        androidx.compose.material.Icon(
                            modifier = Modifier.size(23.dp),
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = { Text(
                        item.title,
                    ) }
                )
            }
        }
    }
}
@Composable
fun Fab(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
){
   FloatingActionButton(
        onClick = {
            scope.launch {
                scaffoldState.snackbarHostState
                    .showSnackbar(
                        "Proximamente disponible!",
                        actionLabel = "Aceptar",
                        duration = SnackbarDuration.Indefinite
                    )
            }
        },
        backgroundColor = SenaGreenClaro
    ) {
        androidx.compose.material.Icon(
            imageVector = Icons.Filled.List,
            contentDescription = "Recompensas"
        )
    }
}