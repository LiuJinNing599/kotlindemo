package com.bw.kotlindemo.contract

import com.bw.kotlindemo.Bean
import com.bw.kotlindemo.LoginBean

/**

 *Time:2019/12/20 16:56
 *Author:刘瑾宁
 *Description:
 */
interface RegisterCallback {
    fun SCSSESS(bean: Bean)
    fun  ERROR(e: String)
}