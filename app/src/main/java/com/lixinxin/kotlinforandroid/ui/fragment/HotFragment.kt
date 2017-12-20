package com.lixinxin.kotlinforandroid.ui.fragment

import com.lixinxin.kotlinforandroid.R
import com.lixinxin.kotlinforandroid.base.BaseFragment
import com.lixinxin.kotlinforandroid.utils.Logger

/**
 * Created by android on 2017/12/15.
 * my
 */

class HotFragment : BaseFragment() {

    override fun findContentView(): Int {
        return R.layout.fragment_hot
    }

    override fun findView() {

    }

    override fun setListener4View() {

    }

    override fun _onCreateView() {
        Logger.e("MyFragment", "MyFragment")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        if (hidden) {
            Logger.e("MyFragment", "不可见")
        } else {
            Logger.e("MyFragment", "可见")
        }
    }
}