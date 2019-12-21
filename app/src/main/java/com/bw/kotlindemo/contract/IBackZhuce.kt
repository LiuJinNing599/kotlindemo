package com.bw.kotlindemo.contract

import com.bw.kotlindemo.Bean
import com.bw.kotlindemo.LoginBean

/**

 *Time:2019/12/20 17:07
 *Author:刘瑾宁
 *Description:
 */
interface IBackZhuce {
    interface IModel{
        fun getmodel(phone :String, nickName:String, pwd :String,callba: RegisterCallback)
    }
    abstract class IPresenter{
        abstract fun getrpesenter(phone :String, nickName:String, pwd :String)
    }
    interface IView {
        fun Desuccess(bean: Bean)
        fun Deerror(e: String)
    }
}