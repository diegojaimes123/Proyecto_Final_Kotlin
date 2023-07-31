package com.example.tienda_sena.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tienda_sena.R
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.google.maps.android.compose.widgets.DisappearingScaleBar
import com.google.maps.android.compose.widgets.ScaleBar


val senaCba = LatLng(4.69606, -74.21563)
val tiendaCba = LatLng(4.696385, -74.218453)
val unidadLacteosCba = LatLng(4.695038, -74.218453)
val unidadAgricolaCba = LatLng(4.694168, -74.218453)


@Composable
fun Page_Inicio() {
    Column {
        MapasScreen()
    }
}

@Composable
fun MapasScreen() {
    val defaultCameraPosition = CameraPosition.fromLatLngZoom(senaCba, 15f)
//    objeto para pasar al mapa
    val cameraPositionState = rememberCameraPositionState {
        position = defaultCameraPosition
    }
//    varible para determinar si el mapa se cargo
    var isMapLoaded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp)
    ) {
        GoogleMapView(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                isMapLoaded = true
            }
        )
        if (!isMapLoaded) {
            AnimatedVisibility(
                visible = !isMapLoaded,
                modifier = Modifier
                    .matchParentSize(),
                enter = EnterTransition.None,
                exit = fadeOut()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .wrapContentSize()
                )
            }
        }
    }
}

@Composable
fun GoogleMapView(
    modifier: Modifier,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    onMapLoaded: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    val senaCbaState = rememberMarkerState(position = senaCba)
    val tiendaCbaState = rememberMarkerState(position = tiendaCba)
    val unidadLacteosCbaState = rememberMarkerState(position = unidadLacteosCba)
    val unidadAgricolaCbaState = rememberMarkerState(position = unidadAgricolaCba)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        GoogleMap(
            modifier = modifier,
            cameraPositionState = cameraPositionState,
            onMapLoaded = onMapLoaded,
        ) {
            Marker(
                state = unidadAgricolaCbaState, title = "Unidad de Produccion Agricolas Cba "
            )
            MarkerInfoWindowContent(
                state = unidadLacteosCbaState,
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
            ) {
                Text(
                    text = "Unidad de Produccion Lacteos CBA", color = Color.Black
                )
            }
            MarkerInfoWindow(
                state = tiendaCbaState,
                icon = BitmapDescriptorFactory.fromResource(R.drawable.logosena)
            ) {
                Box(
                    modifier = Modifier.background(
                        color = MaterialTheme.colorScheme.secondary,
                        shape = RoundedCornerShape(2.dp, 2.dp, 2.dp, 2.dp)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(1.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bg_tienda_cba),
                            contentDescription = null,
                            modifier = Modifier
                                .height(200.dp)
                                .width(200.dp)
                        )
                        Spacer(
                            modifier = Modifier.height(
                                8.dp
                            )
                        )
                        Text(
                            text = "Tienda Sena",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
            content()
        }
        ScaleBar(
            modifier = Modifier
                .padding(top = 5.dp, end = 15.dp)
                .align(Alignment.TopEnd),
            cameraPositionState = cameraPositionState
        )
        DisappearingScaleBar(
            modifier = Modifier
                .padding(top = 5.dp, end = 15.dp)
                .align(Alignment.TopStart),
            cameraPositionState = cameraPositionState
        )
    }
}