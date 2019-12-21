package com.bw.kotlindemo.contract

import com.bw.kotlindemo.LoginBean

/**

 *Time:2019/12/20 17:07
 *Author:刘瑾宁
 *Description:
 */
interface IBack {
    interface IModel{
        fun getmodel(phone :String,pwd :String,callba: LoginCallback)
    }
    abstract class IPresenter{
        abstract fun getrpesenter(phone :String,pwd :String)
    }
    interface IView {
        fun Desuccess(loginBean: LoginBean)
        fun Deerror(e: String)
    }
}