package com.lixinxin.kotlinforandroid.network

import com.lixinxin.kotlinforandroid.mvp.model.data.MeiZhiData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by android on 2017/12/20.
 */
interface ApiService {

    companion object {
        val BASE_URL = "http://gank.io/api/data/"
    }

    @GET("福利/{size}/{page}")
    fun getMeiZhiData(@Path("size") size: Int, @Path("page") page: Int): Observable<MeiZhiData>

}