package com.lixinxin.kotlinforandroid.mvp.presenter

import android.content.Context
import android.os.Handler
import com.lixinxin.kotlinforandroid.mvp.contract.HomeContract
import com.lixinxin.kotlinforandroid.mvp.model.HomeModel
import com.lixinxin.kotlinforandroid.mvp.model.entity.MeiZhiEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by android on 2017/12/20.
 */
class HomePresenter(context: Context, view: HomeContract.View) : HomeContract.Presenter {

    var mContext: Context? = null

    var mView: HomeContract.View? = null

    val mModel: HomeModel by lazy {
        HomeModel()
    }

    init {
        mContext = context
        mView = view
    }

    override fun start() {
        mView?.showProgress()
        requestData()
    }

    override fun end() {
        if (s != null) {
            if (!s!!.isDisposed) {
                s!!.dispose()
            }
        }
    }

    var s: Disposable? = null

    override fun requestData() {

        s = mModel.loadData(this!!.mContext!!)?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribe { x ->
            if (!x.isError) {
                val meizhis: MutableList<MeiZhiEntity> = x.results as MutableList<MeiZhiEntity>
                mView?.setData(meizhis)
            }
        } as Disposable

        Handler().postDelayed({
            mView?.hideProgress()
        }, 3000)
    }
}