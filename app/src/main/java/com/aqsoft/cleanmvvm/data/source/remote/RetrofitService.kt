package com.aqsoft.cleanmvvm.data.source.remote

import com.aqsoft.cleanmvvm.domain.model.Item
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService{

    @GET("remedies/")
    fun getRemedies(): Single<List<Item>>

    @GET("remedies/{id}")
    fun getRemedyById(@Path("id") id: Long): Single<Item>

}