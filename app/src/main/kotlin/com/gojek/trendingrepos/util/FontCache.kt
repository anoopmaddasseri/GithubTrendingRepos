/*
 * @author   Anoop Maddasseri <anoopmaddasseri@gmail.com>
 * @version  1
 * @since    15th Feb 2020
 *
 * P.S. Increment version when editing
 */

@file:JvmName("FontCache")

package com.gojek.trendingrepos.util

import android.content.Context
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat

private val APP_FONT_CACHE = HashMap<String, Typeface>()

fun getTypeface(fontName: String, fontId: Int, context: Context): Typeface? {
    var typeface = APP_FONT_CACHE[fontName]

    if (typeface == null) {
        try {
            typeface = ResourcesCompat.getFont(context, fontId)
        } catch (e: Exception) {
            return null
        }

        APP_FONT_CACHE[fontName] = typeface!!
    }

    return typeface
}