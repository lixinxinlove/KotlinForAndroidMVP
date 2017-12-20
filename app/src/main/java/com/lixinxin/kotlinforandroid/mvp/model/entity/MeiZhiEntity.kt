package com.lixinxin.kotlinforandroid.mvp.model.entity

/**
 * Created by android on 2017/12/20.
 */

data class MeiZhiEntity(var _id: String? = null,
                        var createdAt: String? = null,
                        var desc: String? = null,
                        var publishedAt: String? = null,
                        var source: String? = null,
                        var type: String? = null,
                        var url: String? = null,
                        var isUsed: Boolean = false,
                        var who: String? = null)
