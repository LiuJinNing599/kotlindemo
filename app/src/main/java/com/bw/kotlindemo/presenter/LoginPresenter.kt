package com.bw.kotlindemo.presenter

import com.bw.kotlindemo.LoginBean
import com.bw.kotlindemo.MainActivity
import com.bw.kotlindemo.contract.IBack
import com.bw.kotlindemo.contract.LoginCallback
import com.bw.kotlindemo.model.ModelIm
import java.util.*

/**

 *Time:2019/12/20 17:53
 *Author:刘瑾宁
 *Description:
 */
class LoginPresenter(iView: MainActivity) :IBack.IPresenter(){
    private var modelIm :ModelIm ?=null
    private var iView: IBack.IView ?=null
    init {
        this.iView =iView
        modelIm = ModelIm()
    }
    override fun getrpesenter(phone: String, pwd: String) {
        modelIm!!.getmodel(phone,pwd,object : LoginCallback{
            override fun SCSSESS(bean: LoginBean) {
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