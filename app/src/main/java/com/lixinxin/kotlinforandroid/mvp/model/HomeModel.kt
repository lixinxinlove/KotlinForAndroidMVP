package com.lixinxin.kotlinforandroid.mvp.model

import android.content.Context
import com.lixinxin.kotlinforandroid.mvp.model.data.MeiZhiData
import com.lixinxin.kotlinforandroid.network.ApiService
import com.lixinxin.kotlinforandroid.network.RetrofitClient
import io.reactivex.Observable

/**
 * Created by android on 2017/12/20.
 */
class HomeModel {

    fun loadData(context: Context): Observable<MeiZhiData>? {

        val retrofitClient = RetrofitClient.getInstance(context, ApiService.BASE_URL)

        val apiService = retrofitClient.create(ApiService::class.java)

        return apiService?.getMeiZhiData(10, 1)
    }

}