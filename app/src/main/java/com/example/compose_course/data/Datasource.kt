package com.example.compose_course.data

import android.annotation.SuppressLint
import com.example.compose_course.R
import com.example.compose_course.model.Courses

class Datasource {
    @SuppressLint("ResourceType")
    fun loadCourses(): List<Courses>{
        return listOf(
            Courses(R.string.architecture, 58, R.drawable.architecture),
            Courses(R.string.crafts, 121, R.drawable.crafts),
            Courses(R.string.business, 78, R.drawable.business),
            Courses(R.string.culinary, 118, R.drawable.culinary),
            Courses(R.string.design, 423, R.drawable.design),
            Courses(R.string.fashion, 92, R.drawable.fashion),
            Courses(R.string.film, 165, R.drawable.film),
            Courses(R.string.gaming, 164, R.drawable.gaming),
            Courses(R.string.drawing, 326, R.drawable.drawing),
            Courses(R.string.lifestyle, 305, R.drawable.lifestyle),
            Courses(R.string.music, 212, R.drawable.music),
            Courses(R.string.painting, 172, R.drawable.painting),
            Courses(R.string.photography, 321, R.drawable.photography),
            Courses(R.string.tech, 118, R.drawable.tech)

        )
    }

}



