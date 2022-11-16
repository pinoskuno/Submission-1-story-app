package com.storyappsubmission1.Data.Functon
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText



class PasswordEditText : AppCompatEditText, View.OnFocusChangeListener {

    companion object {
        private const val MIN_LENGTH = 6
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
        hint = "Please enter your password"
        textAlignment = TEXT_ALIGNMENT_VIEW_START
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        if (!hasFocus && !text.isNullOrEmpty() && (text?.length ?: 0) < MIN_LENGTH)
            error = "Password anda salah"
    }

    private fun init() {
        onFocusChangeListener = this
    }
}