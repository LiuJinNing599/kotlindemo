package com.bw.kotlindemo.util

import android.app.Application
import android.content.Context

/**

 *Time:2019/12/20 16:27
 *Author:刘瑾宁
 *Description:
 */
class BaseApplication : Application() {

   companion object{
       lateinit var mcontext : Context
       fun getContezt() : Context{
           return  mcontext
       }
   }
    override fun onCreate() {
        super.onCreate()
        mcontext =this
    }
}