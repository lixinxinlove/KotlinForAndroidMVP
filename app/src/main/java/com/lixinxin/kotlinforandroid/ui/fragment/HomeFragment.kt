package com.lixinxin.kotlinforandroid.ui.fragment

import android.animation.Animator
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.support.annotation.ColorInt
import android.support.annotation.NonNull
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.lixinxin.kotlinforandroid.R
import com.lixinxin.kotlinforandroid.base.BaseFragment
import com.lixinxin.kotlinforandroid.base.BasePresenter
import com.lixinxin.kotlinforandroid.mvp.contract.HomeContract
import com.lixinxin.kotlinforandroid.mvp.model.entity.MeiZhiEntity
import com.lixinxin.kotlinforandroid.mvp.presenter.HomePresenter
import com.lixinxin.kotlinforandroid.utils.Logger

/**
 * Created by android on 2017/12/15.
 */
class HomeFragment : BaseFragment(), HomeContract.View {

    var presenter: BasePresenter? = null
    var mProgress: ProgressBar? = null

    override fun findContentView(): Int {
        return R.layout.fragment_home
    }

    override fun findView() {
        mProgress = rootView?.findViewById(R.id.progress)
    }

    override fun setListener4View() {
    }

    override fun _onCreateView() {
        presenter = HomePresenter(context, this)
        presenter?.start()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        if (hidden) {
            presenter?.end()
            Logger.e("HomeFragment", "不可见")
        } else {
            Logger.e("HomeFragment", "可见")
        }
    }

    override fun showProgress() {
        mProgress?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        mProgress?.visibility = View.GONE
    }

    override fun setData(users: MutableList<MeiZhiEntity>) {

        for (user in users) {
            Logger.e("llll", user.url!!)
        }
    }




    override fun onDestroy() {
        presenter?.end()
        //presenter = null
        super.onDestroy()
    }
}


