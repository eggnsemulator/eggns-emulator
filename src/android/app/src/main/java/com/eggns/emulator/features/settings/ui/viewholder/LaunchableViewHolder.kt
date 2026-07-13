// SPDX-FileCopyrightText: Copyright 2025 Eden Emulator Project
// SPDX-License-Identifier: GPL-3.0-or-later

package com.eggns.emulator.features.settings.ui.viewholder

import android.view.View
import com.eggns.emulator.R
import com.eggns.emulator.databinding.ListItemSettingBinding
import com.eggns.emulator.features.settings.model.view.LaunchableSetting
import com.eggns.emulator.features.settings.model.view.SettingsItem
import com.eggns.emulator.features.settings.ui.SettingsAdapter
import com.eggns.emulator.utils.ViewUtils.setVisible

class LaunchableViewHolder(val binding: ListItemSettingBinding, adapter: SettingsAdapter) :
    SettingViewHolder(binding.root, adapter) {
    private lateinit var setting: LaunchableSetting

    override fun bind(item: SettingsItem) {
        setting = item as LaunchableSetting

        binding.textSettingName.text = setting.title
        binding.textSettingDescription.setVisible(setting.description.isNotEmpty())
        binding.textSettingDescription.text = setting.description

        binding.textSettingValue.setVisible(true)
        binding.textSettingValue.text = ""
        binding.textSettingValue.setCompoundDrawablesRelativeWithIntrinsicBounds(
            0, 0, R.drawable.ic_arrow_forward, 0
        )

        binding.buttonClear.setVisible(false)
    }

    override fun onClick(clicked: View) {
        adapter.onLaunchableClick(setting)
    }

    override fun onLongClick(clicked: View): Boolean {
        // no-op
        return true
    }
}
