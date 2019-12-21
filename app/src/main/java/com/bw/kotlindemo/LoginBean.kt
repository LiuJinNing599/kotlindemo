package com.bw.kotlindemo
/**

 *Time:2019/12/20 17:40
 *Author:刘瑾宁
 *Description:
 */
data class LoginBean(
    val message: String,
    val result: Result,
    val status: String
)

data class Result(
    val headPic: String,
    val nickName: String,
    val phone: String,
    val pwd: String,
    val sessionId: String,
    val userId: Int,
    val userName: String,
    val whetherFaceId: Int,
    val whetherVip: Int
)