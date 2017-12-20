package com.lixinxin.kotlinforandroid.view


import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by android on 2017/12/15.
 */
class VerticalViewPager(context: Context) : ViewPager(context) {

    init {
    }

    constructor(context: Context, attrs: AttributeSet) : this(context) {
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : this(context, attrs) {
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return super.onTouchEvent(swapTouchEvent(ev!!))
    }

    private fun swapTouchEvent(event: MotionEvent): MotionEvent {
        val width = getWidth()
        val height = getHeight()
        event.setLocation((event.getY() / height) * width, (event.getX() / width) * height)
        return event
    }

}