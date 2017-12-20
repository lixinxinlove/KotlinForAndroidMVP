package com.lixinxin.kotlinforandroid.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by android on 2017/12/15.
 */
abstract class BaseFragment : Fragment() {

    protected var rootView: View? = null

    abstract fun findContentView(): Int

    abstract fun findView()

    abstract fun setListener4View()

    abstract fun _onCreateView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater?.inflate(findContentView(), null)
        findView()
        setListener4View()
        _onCreateView()
        return rootView
    }
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}