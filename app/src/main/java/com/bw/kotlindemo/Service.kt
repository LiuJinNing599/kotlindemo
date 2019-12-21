package com.bw.kotlindemo

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

/**

 *Time:2019/12/20 16:13
 *Author:刘瑾宁
 *Description:
 */
interface Service {

    @POST("techApi/user/v1/register")
    fun RegisterService(@Query("phone") phone:String, @Query("nickName") nickName:String, @Query("pwd") pwd:String):Observable<Bean>

    @POST("techApi/user/v1/login")
    fun LoginService(@Query("phone") phone:String, @Query("pwd") pwd:String):Observable<LoginBean>
}