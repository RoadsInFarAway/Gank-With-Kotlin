package com.winton.gank.gank.http.api

import com.winton.gank.gank.http.response.gank.CategoryResponse
import com.winton.gank.gank.http.response.gank.TodayResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author: winton
 * @time: 2018/10/9 下午4:06
 * @desc: gank Api
 */
interface GankApi {

    companion object {
        const val baseUrl:String ="http://gank.io/api/"
    }

    /**
     * 今日推荐
     */
    @GET("today")
    fun today():Flowable<TodayResponse>

    /**
     * 获取分类的接口
     */
    @GET("data/{category}/{pageNum}/{pageIndex}")
    fun category(@Path("category")category: String,@Path("pageNum")pageNum:Int,@Path("pageIndex")pageIndex:Int):Flowable<CategoryResponse>

    /**
     * 查询接口
     */
    @GET("search/query/{key}/category/{category}/count/{pageNum}/page/{pageIndex}")
    fun search(@Path("key")key:String,@Path("category")category:String,@Path("pageNum")pageNum:Int,@Path("pageIndex")pageIndex:Int):Flowable<CategoryResponse>

}