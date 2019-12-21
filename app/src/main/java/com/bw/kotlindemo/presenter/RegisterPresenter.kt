package com.bw.kotlindemo.presenter

import com.bw.kotlindemo.Bean
import com.bw.kotlindemo.LoginBean
import com.bw.kotlindemo.Main3Activity
import com.bw.kotlindemo.MainActivity
import com.bw.kotlindemo.contract.IBack
import com.bw.kotlindemo.contract.IBackZhuce
import com.bw.kotlindemo.contract.LoginCallback
import com.bw.kotlindemo.contract.RegisterCallback
import com.bw.kotlindemo.model.ModeRegister
import com.bw.kotlindemo.model.ModelIm
import java.util.*

/**

 *Time:2019/12/20 17:53
 *Author:刘瑾宁
 *Description:
 */
class RegisterPresenter(iView: Main3Activity) : IBackZhuce.IPresenter() {


    private var modelIm :ModeRegister ?=null
    private var iView: IBackZhuce.IView ?=null
    init {
        this.iView =iView
        modelIm = ModeRegister()
    }
    override fun getrpesenter(phone: String, nickName: String, pwd: String) {
         modelIm!!.getmodel(phone,nickName,pwd,object :RegisterCallback{
             override fun SCSSESS(bean: Bean) {
                 if (iView !=null){
                     iView!!.Desuccess(bean)
                 }
             }

             override fun ERROR(e: String) {
                 TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
             }

         })
    }

}