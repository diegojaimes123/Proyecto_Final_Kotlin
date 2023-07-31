package com.example.tienda_sena.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tienda_sena.R

@Composable
fun Page_Contenidos() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                color = Color.Green,
                text = "           Nuevas Cosas",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(bottom = 15.dp),
//                    .size(17.dp)
                //            textAlign = Alignment.CenterHorizontally
            )
        }
        Card(
//            elevation = ,
            shape = RoundedCornerShape(8.dp),
            ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Productos Recomendados y de mayor compra",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Image(
                    painter = painterResource(R.drawable.bg_tienda_cba),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        //                    .border(2.dp)
                        .height(260.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        Card(
//            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp),

            ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Productos Proximamente en la tienda ",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Image(
                    painter = painterResource(R.drawable.ic_frutas_verduras),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        //                    .border(2.dp)
                        .height(260.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}