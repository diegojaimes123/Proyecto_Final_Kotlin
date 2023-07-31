package com.example.tienda_sena.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tienda_sena.R

//    val idNotification = 0
//    val context: Context = LocalContext.current
//    val idChannel: String = stringResource(R.string.canal_Tienda)
//    val name: String = stringResource(R.string.canal_Tienda)
//    val descripcionTExt: String = stringResource(R.string.canal_Notifi)
//
//    val textShort = "ejemplo de notificacion sencilla con prioridad con omision (default) "
//    val textLong: String =
//        "Saludos, esta es un aprueba de notificacion. Debe Aparecer " + "un icono a la derecha y el texto puede tener un alongitud de 200 caracteres " + "el tamano de la notificacion puede colapsar y/o expandirse " + "Gracias y hasta pronto "
//    val iconBig = BitmapFactory.decodeResource(
//        context.resources, R.drawable.logo_sena
//    )
//    val imageBig = BitmapFactory.decodeResource(
//        context.resources, R.drawable.bg_tienda_cba
//    )

@Composable
fun Page_Informacion() {
    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp),
            shadowElevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_lacteos),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "En esta tienda encontraremos gran variedad de ")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Frutas y verduras de todo tipo ")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp),
            shadowElevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_lacteos),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "En esta tienda encontraremos gran variedad de ")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Lacteos y derivados  de todo tipo ")
            }
        }
    }
}
