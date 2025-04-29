package ru.alexeyivannikov.lab17

import android.os.CountDownTimer
import com.google.android.material.badge.BadgeDrawable
import kotlin.random.Random

object NotificationTimer {

    var notificationCounter = 0
    var badge: BadgeDrawable? = null


    val timer = object : CountDownTimer(Long.MAX_VALUE, 2_000) {
        override fun onTick(p0: Long) {
            notificationCounter += Random.nextInt(1, 5)

            badge?.number = notificationCounter
        }

        override fun onFinish() {}

    }

    fun clear() {
        notificationCounter = 0
        badge?.isVisible = false
    }

    fun start() {
        timer.start()
        badge?.isVisible = true
    }

    fun stop() {
        timer.cancel()
    }
}