package com.lixinxin.kotlinforandroid.utils

import android.util.Log

/**
 * Created by android on 2017/12/15.
 */
object Logger {

    var isDebug = true

    fun i(tag: String, content: String) {
        if (isDebug) {
            Log.i(tag, content)
        }
    }

    fun d(tag: String, content: String) {
        if (isDebug) {
            Log.d(tag, content)
        }
    }

    fun w(tag: String, content: String) {
        if (isDebug) {
            Log.w(tag, content)
        }
    }

    fun e(tag: String, content: String) {
        if (isDebug) {
            Log.e(tag, content)
        }
    }
}