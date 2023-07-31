package com.example.tienda_sena.pages.login

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.example.tienda_sena.comp_login.PageScreen
import com.example.dashboard_v1.components.CreateChannelNotification
import com.example.dashboard_v1.components.notificacionSencilla
import com.example.tienda_sena.R
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout.RESIZE_MODE_ZOOM
import com.google.android.exoplayer2.ui.StyledPlayerView


@Composable
fun VideoView(videoUri: String) {
    val context = LocalContext.current

    val exoPlayer = ExoPlayer.Builder(LocalContext.current)
        .build()
        .also { exoPlayer ->
            val mediaItem = MediaItem.Builder()
                .setUri(videoUri)
                .build()
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
            exoPlayer.playWhenReady = true
            exoPlayer.repeatMode = Player.REPEAT_MODE_ALL
        }
    DisposableEffect(
        AndroidView(factory = {
            StyledPlayerView(context).apply {
                player = exoPlayer
                useController = false
                resizeMode = RESIZE_MODE_ZOOM
            }
        }, modifier = Modifier.fillMaxSize()
        )
    ){
        onDispose { exoPlayer.release() }
    }
}

@Composable
fun LoginScreen(
    navController: NavHostController
) {


    val idNotification = 0
    val context: Context = LocalContext.current
    val idChannel: String = stringResource(R.string.canal_Tienda)
    val name: String = stringResource(R.string.canal_Tienda)
    val descripcionTExt: String = stringResource(R.string.canal_Notifi)

    val textShort = "ejemplo de notificacion sencilla con prioridad con omision (default)"
    LaunchedEffect(Unit) {
        CreateChannelNotification(
            idChannel, context, name, descripcionTExt
        )
    }
    val showLoginForm = rememberSaveable() {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        VideoView(videoUri = "android.resource://com.example.tienda_sena/raw/senagif")
        Column(
            Modifier.padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,

        ) {
                Card(
                    shape = RoundedCornerShape(19.dp,),
                    modifier = Modifier
                        .padding(20.dp),
                    backgroundColor = MaterialTheme.colors.secondary.copy(alpha = 0.2f)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Spacer(
                            modifier = Modifier
                                .height(5.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.logosena),
                            contentDescription = "Logo",
                            modifier = Modifier.size(130.dp, 130.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .height(10.dp)
                        )
                        if (showLoginForm.value) {
                            Text(
                                text = "Inicia Sesion"
                            )
                            UserForm(
                                isCreateAcount = true
                            ) { email, password ->
                                Log.d("TiendaApp", "Inicio de sesion con $email y $password")
                                navController.navigate(PageScreen.DashBoard.name)
                                notificacionSencilla(
                                    context,
                                    idChannel,
                                    idNotification,
                                    "Inicio sesion $email.  con $password",
                                    textShort
                                )
                            }
                        } else {
                            Text(
                                text = "Crear Cuenta Nueva"
                            )
                            UserForm(
                                isCreateAcount = false
                            ) { email, password ->
                                Log.d("TiendaApp", "Creando Cuenta  con $email y $password")
                                navController.navigate(PageScreen.DashBoard.name)
                                notificacionSencilla(
                                    context,
                                    idChannel,
                                    idNotification,
                                    "Se  Creo la Cuenta con  $email.  con $password",
                                    textShort
                                )
                            }
                        }
                        Spacer(
                            modifier = Modifier
                                .height(10.dp)
                        )
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val text1 =
                                if (showLoginForm.value)
                                    "No tiene cuenta ?"
                                else
                                    "Ya Tienes Cuenta?"
                            val text2 =
                                if (showLoginForm.value)
                                    "Registrate"
                                else
                                    "Inicia Sesion"
                            Text(
                                text = text1,
//                                modifier = Modifier.size(10.dp)
                            )
                            Text(
                                text = text2,
                                modifier = Modifier
                                    .clickable {
                                        showLoginForm.value = !showLoginForm.value
                                        notificacionSencilla(
                                            context,
                                            idChannel,
                                            idNotification,
                                            "Inicio sesion   con passwordX",
                                            textShort
                                        )
                                    }
                                    .padding(start = 5.dp),
                                color = Color.Blue
                            )
                        }
                    }
                }

        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(
    isCreateAcount: Boolean,
    onDone: (String, String) -> Unit = { email, pws -> }
) {
    val email = rememberSaveable() {
        mutableStateOf("")
    }
    val password = rememberSaveable() {
        mutableStateOf("")
    }
    val passwordVisible = rememberSaveable() {
        mutableStateOf(false)
    }
    val validState = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailImput(
            emailState = email
        )
        PasswordImput(
            passwordState = password,
            labelId = "Password",
            passwordVisible = passwordVisible
        )
        Spacer(
            modifier = Modifier.height(15.dp)
        )
        SubmitButton(
            textId =
            if (isCreateAcount)
                "Crear Cuenta"
            else
                "Iniciar sesion",
            inputValid = validState
        ) {
            onDone(email.value.trim(), password.value.trim())
            keyboardController?.hide()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImputField(
    valueSate: MutableState<String>,
    labelId: String,
    keyboardType: KeyboardType,
    isSingleLine: Boolean = true
) {
    OutlinedTextField(
        value = valueSate.value,
        onValueChange = { valueSate.value = it },
        label = { Text(text = labelId) },
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(
                bottom = 10.dp,
                start = 10.dp,
                end = 10.dp,
            )
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}

@Composable
fun EmailImput(
    emailState: MutableState<String>,
    labelId: String = "Email"
) {
    ImputField(
        valueSate = emailState,
        labelId = labelId,
        keyboardType = KeyboardType.Email
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordImput(
    passwordState: MutableState<String>,
    labelId: String,
    passwordVisible: MutableState<Boolean>
) {
    val visualTransformation =
        if (passwordVisible.value)
            VisualTransformation.None
        else PasswordVisualTransformation()
    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = { Text(text = labelId) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .padding(
                bottom = 10.dp,
                start = 10.dp,
                end = 10.dp
            )
            .fillMaxWidth(),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (passwordState.value.isNotBlank())
                PasswordVisibleIcon(passwordVisible)
        }
    )
}

@Composable
fun PasswordVisibleIcon(
    passwordVisible: MutableState<Boolean>
) {
    val image =
        if (passwordVisible.value)
            Icons.Default.VisibilityOff
        else
            Icons.Default.Visibility
    IconButton(
        onClick = { passwordVisible.value = !passwordVisible.value }
    ) {
        Icon(
            imageVector = image,
            contentDescription = ""
        )
    }
}


@Composable
fun SubmitButton(
    textId: String,
    inputValid: Boolean,
    onClic: () -> Unit,
) {
    Button(
        onClick = onClic,
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape,
        enabled = inputValid
    ) {
        Text(
            text = textId,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}
