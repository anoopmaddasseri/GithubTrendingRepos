/*
 * @author   Anoop Maddasseri <anoopmaddasseri@gmail.com>
 * @version  1
 * @since    15th Feb 2020
 *
 * P.S. Increment version when editing
 */
package com.gojek.trendingrepos.util

enum class FontType(private val fontType: Int) {
    ROBOTO_LIGHT(0),
    ROBOTO_REGULAR(1),
    ROBOTO_MEDIUM(2),
    ROBOTO_BOLD(3);

    companion object {
        fun from(fontType: Int): FontType = values().first { it.fontType == fontType }
    }
}