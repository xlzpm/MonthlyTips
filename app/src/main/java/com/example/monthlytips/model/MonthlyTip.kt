package com.example.monthlytips.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.monthlytips.R

data class MonthlyTip(
    val day: Int,
    @StringRes val tipRes: Int,
    @DrawableRes val imgRes: Int,
)
