// SPDX-FileCopyrightText: 2023 yuzu Emulator Project
// SPDX-License-Identifier: GPL-2.0-or-later

package com.eggns.emulator.features.settings.model

interface AbstractBooleanSetting : AbstractSetting {
    fun getBoolean(needsGlobal: Boolean = false): Boolean
    fun setBoolean(value: Boolean)
}
