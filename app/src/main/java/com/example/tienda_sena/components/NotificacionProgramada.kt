package com.example.dashboard_v1.components

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.tienda_sena.MainActivity
import com.example.dashboard_v1.utils.Constants.channelId
import com.example.tienda_sena.R

class NotificacionProgramada : BroadcastReceiver() {
//    Objeto que ro require ser instancoado de un cakse

    companion object {
        const val NOTIFICATION_ID = 5
    }

    override fun onReceive(
        context: Context?,
        intent: Intent?
    ) {
        crearNotifiacion(context)
//        TODO("Not yet implemented")
    }

    private fun crearNotifiacion(
        context: Context?
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

        val notification = NotificationCompat.Builder(
            context!!,
            channelId
        )
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Notificacion programada")
            .setContentText("Saludos! A programar notificaciones aprendices ")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText(
                        "saludos esta es un aprueba de notificaciones " +
                                "Programada aparece despues de un tiempo, incluso " +
                                "si la APP esta cerrada. Podemos usar las otras" +
                                "caracteristicas de una notificaio ya usada " +
                                "da clic para abrir la APP"
                    )
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        manager.notify(
            NOTIFICATION_ID,
            notification
        )
    }
}