package com.example.compose_course.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Courses(
    @StringRes
    val coursesNameId: Int,
    val coursesTotalId: Int,
    @DrawableRes
    val coursesImageId: Int

)
