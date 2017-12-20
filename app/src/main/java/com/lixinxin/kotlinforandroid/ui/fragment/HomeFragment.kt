package com.lixinxin.kotlinforandroid.ui.fragment

import android.view.View
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
    }

    override fun onDestroy() {
        presenter = null
        super.onDestroy()
    }
}