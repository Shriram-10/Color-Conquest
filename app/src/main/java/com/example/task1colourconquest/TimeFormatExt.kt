package com.example.task1colourconquest

import java.util.concurrent.TimeUnit

object TimeFormatExt {
    private const val FORMAT = "%02d:%02d"

    fun Long.timeFormat(): String = String.format(
        FORMAT,
        TimeUnit.MILLISECONDS.toMinutes(this) % 60,
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )
}