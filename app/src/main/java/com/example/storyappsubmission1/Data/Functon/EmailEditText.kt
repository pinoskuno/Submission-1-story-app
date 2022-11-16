package com.storyappsubmission1.storyapps.view.custom

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText



class EmailEditText : AppCompatEditText, View.OnFocusChangeListener {

    companion object {
        private val emailRegex: Regex = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+\$")
    }

    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        hint = "Enter Email"
        textAlignment = TEXT_ALIGNMENT_VIEW_START
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        if (!hasFocus && !text.isNullOrEmpty() && !emailRegex.matches(text.toString()))
            error = "Password Invalid"
    }

    private fun init() {
        onFocusChangeListener = this
    }
}