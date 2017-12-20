package com.lixinxin.kotlinforandroid.mvp.contract

import com.lixinxin.kotlinforandroid.base.BasePresenter
import com.lixinxin.kotlinforandroid.base.BaseView
import com.lixinxin.kotlinforandroid.mvp.model.entity.MeiZhiEntity
import com.lixinxin.kotlinforandroid.mvp.model.entity.UserEntity

/**
 * Created by android on 2017/12/20.
 */
interface HomeContract {
    interface View : BaseView<Presenter> {
        fun setData(users: MutableList<MeiZhiEntity>)
    }

    interface Presenter : BasePresenter {
        fun requestData()
    }
}