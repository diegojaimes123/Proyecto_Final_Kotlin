package com.example.dashboard_v1.components

import android.Manifest
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.tienda_sena.MainActivity
import com.example.dashboard_v1.components.NotificacionProgramada.Companion.NOTIFICATION_ID
import com.example.tienda_sena.R
import java.util.Calendar

fun CreateChannelNotification(
    idChannel: String,
    context: Context,
    name: String,
    descriptionText: String
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val importance = NotificationManager.IMPORTANCE_DEFAULT
//    defuinicion del canal
        val channel = NotificationChannel(
            idChannel,
            name,
            importance
        ).apply {
            description = descriptionText
        }
//        definicion del gestor de NOtificaaciones
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

//        creaccion del canal

        notificationManager.createNotificationChannel(channel)
    }
}

fun notificacionSencilla(
    context: Context,
    idChannel: String,
    idNotificacion: Int,
    textTitle: String,
    textContent: String,
    priority: Int = NotificationCompat.PRIORITY_DEFAULT
) {
    val intent = Intent(
        context,
        MainActivity::class.java
    ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context,
        0,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.ic_recycling_24)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    with(NotificationManagerCompat.from(context)) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        notify(idNotificacion, builder)
    }
}

fun noticacionExtensa(
    context: Context,
    idChannel: String,
    idNotificacion: Int,
    textTitle: String,
    textContent: String,
    bigIcono: Bitmap,
    priority: Int = NotificationCompat.PRIORITY_DEFAULT
) {
    val builder = NotificationCompat.Builder(
    context,
        idChannel
    )
        .setSmallIcon(R.drawable.ic_recycling_24)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setLargeIcon(bigIcono)
        .setStyle(
            NotificationCompat.BigTextStyle()
                .bigText(textContent)
        )
        .setPriority(priority)
        .build()

    with(NotificationManagerCompat.from(context)) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        notify(idNotificacion, builder)
    }
}

fun notificacionImagen(
    context: Context,
    idChannel: String,
    idNotificacion: Int,
    textTitle: String,
    textContent: String,
    bigIcono: Bitmap,
    bigImagen: Bitmap,
    priority: Int = NotificationCompat.PRIORITY_DEFAULT
) {
    val intent = Intent(
        context,
        MainActivity::class.java
    ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context,
        0,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.ic_recycling_24)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setLargeIcon(bigIcono)
        .setStyle(
            NotificationCompat
                .BigPictureStyle()
                .bigPicture(bigImagen)
                .setBigContentTitle("Tienda sena Cba ")
        )
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    with(NotificationManagerCompat.from(context)) {
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        notify(idNotificacion, builder)
    }
}

fun notificacionProgramada(
    context: Context
) {
//    Intent describe la actividad que se debe iniciar y contine los datos necesario para ello

    val intent = Intent(
        context,
        NotificacionProgramada::class.java
    ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

//un pendidn Intet es una referencia a un token que mantine el sistema
//    la aplicacion A puede usar un PendingIntent a la aplicacion B para permitir
//    que la aplicacion B ejecute accion es predefinidas en nombre de la aplicacion A
//            independiene de si esta sigue activa

    val pendingIntent: PendingIntent = PendingIntent.getBroadcast(
        context,
        NOTIFICATION_ID,
        intent,
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )

//    alarm manager programa la notificacion
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    alarmManager.setExact(
        AlarmManager.RTC_WAKEUP,
        Calendar.getInstance().timeInMillis + 10000,
        pendingIntent
    )
}

