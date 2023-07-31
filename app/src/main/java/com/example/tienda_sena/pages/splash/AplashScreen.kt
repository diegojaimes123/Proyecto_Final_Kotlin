package com.example.tienda_sena.pages.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tienda_sena.R
import com.example.tienda_sena.comp_login.PageScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {
    LaunchedEffect(
        key1 = true,
    ){
        delay(1000)
        navController.popBackStack()
        navController.navigate(PageScreen.Login.name)
    }
    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logosena),
            contentDescription = "Logo",
            modifier = Modifier.size(180.dp, 180.dp)
        )
        Text(
            text = "Bienvenid@s",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    }
}