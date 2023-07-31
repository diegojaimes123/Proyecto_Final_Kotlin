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


@Composable
fun Page_Ver_mas() {
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
                    painter = painterResource(id = R.drawable.bg_tienda_cba),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Podremos disfrutar de una gran variedad de productos")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "tales como frutas, verduras, carnes y flores ")
            }
        }
    }
}
