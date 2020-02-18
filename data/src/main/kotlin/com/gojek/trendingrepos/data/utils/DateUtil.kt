/*
 * @author   Anoop Maddasseri <anoopmaddasseri@gmail.com>
 * @version  1
 * @since    19th Feb 2020
 *
 * P.S. Increment version when editing
 */

@file:JvmName("DateUtil")

package com.gojek.trendingrepos.data.utils


import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


fun formatDate(pattern: String): String {
    val calendar = Calendar.getInstance(Locale.getDefault())
    return DateFormat.format(pattern, calendar).toString()
}

fun formatDate(calendar: Calendar, pattern: String): String =
    DateFormat.format(pattern, calendar).toString()

fun convertedDate(inputPattern: String, outputPattern: String, stringDate: String): String {
    val originalFormat = SimpleDateFormat(inputPattern, Locale.US)
    val targetFormat = SimpleDateFormat(outputPattern, Locale.US)
    val requiredFormat = originalFormat.parse(stringDate)
    return targetFormat.format(requiredFormat)
}

fun isTimeWithInInterval(valueToCheckInSeconds: Long, startTime: Long, endTime: Long): Boolean {
    val startTimeInMinutes = TimeUnit.MILLISECONDS.toMinutes(startTime)
    val endTimeInMinutes = TimeUnit.MILLISECONDS.toMinutes(endTime)
    val valueToCheckInMinutes = TimeUnit.SECONDS.toMinutes(valueToCheckInSeconds)
    AppLogger.logD(
        "isTimeWithInInterval - Difference {}",
        "${startTimeInMinutes - endTimeInMinutes}"
    )
    AppLogger.logD(
        "isTimeWithInInterval {}",
        "${startTimeInMinutes - endTimeInMinutes > valueToCheckInMinutes}"
    )
    return startTimeInMinutes - endTimeInMinutes > valueToCheckInMinutes
}