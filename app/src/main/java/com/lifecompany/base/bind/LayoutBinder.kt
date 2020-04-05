package com.lifecompany.base.bind

import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

object LayoutBinder {

    fun bind(activity: AppCompatActivity) {
        val cls = activity.javaClass
        if (!cls.isAnnotationPresent(Layout::class.java)) return
        val layout = cls.getAnnotation(Layout::class.java) as Layout
        activity.setContentView(layout.value)
    }

    fun bind(inflater: LayoutInflater, fragment: Fragment): View? {
        val cls = fragment.javaClass
        if (!cls.isAnnotationPresent(Layout::class.java)) return null
        val layout = cls.getAnnotation(Layout::class.java) as Layout
        return inflater.inflate(layout.value, null)
    }

}
