// SPDX-FileCopyrightText: Copyright 2025 Eden Emulator Project
// SPDX-License-Identifier: GPL-3.0-or-later

package com.eggns.emulator.applets.web

import android.content.Intent
import android.net.Uri
import androidx.annotation.Keep
import com.eggns.emulator.NativeLibrary
import com.eggns.emulator.utils.Log

/**
    Should run WebBrowser as a new intent.
*/

@Keep
object WebBrowser {
    @JvmStatic
    fun openExternal(url: String) {
        val activity = NativeLibrary.sEmulationActivity.get() ?: run {
            return
        }

        activity.runOnUiThread {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                activity.startActivity(intent)
            } catch (e: Exception) {
                Log.error("WebBrowser failed to launch $url: ${e.message}")
            }
        }
    }
}
