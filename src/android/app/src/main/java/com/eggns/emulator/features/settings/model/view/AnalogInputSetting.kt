// SPDX-FileCopyrightText: 2024 yuzu Emulator Project
// SPDX-License-Identifier: GPL-2.0-or-later

package com.eggns.emulator.features.settings.model.view

import androidx.annotation.StringRes
import com.eggns.emulator.features.input.NativeInput
import com.eggns.emulator.features.input.model.AnalogDirection
import com.eggns.emulator.features.input.model.InputType
import com.eggns.emulator.features.input.model.NativeAnalog
import com.eggns.emulator.utils.ParamPackage

class AnalogInputSetting(
    override val playerIndex: Int,
    val nativeAnalog: NativeAnalog,
    val analogDirection: AnalogDirection,
    @StringRes titleId: Int = 0,
    titleString: String = ""
) : InputSetting(titleId, titleString) {
    override val type = TYPE_INPUT
    override val inputType = InputType.Stick

    override fun getSelectedValue(): String {
        val params = NativeInput.getStickParam(playerIndex, nativeAnalog)
        val analog = analogToText(params, analogDirection.param)
        return getDisplayString(params, analog)
    }

    override fun setSelectedValue(param: ParamPackage) =
        NativeInput.setStickParam(playerIndex, nativeAnalog, param)
}
