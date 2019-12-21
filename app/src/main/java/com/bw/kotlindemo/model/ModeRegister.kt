package com.bw.kotlindemo.model

import com.bawei.kotlin.network.RetrofitManger
import com.bw.kotlindemo.Bean
import com.bw.kotlindemo.LoginBean
import com.bw.kotlindemo.Service
import com.bw.kotlindemo.contract.IBack
import com.bw.kotlindemo.contract.IBackZhuce
import com.bw.kotlindemo.contract.LoginCallback
import com.bw.kotlindemo.contract.RegisterCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**

 *Time:2019/12/20 16:50
 *Author:刘瑾宁
 *Description:
 */
class ModeRegister  : IBackZhuce.IModel{

    private var  service : Service ?=null

    override fun getmodel(phone: String, nickName: String, pwd: String, callba: RegisterCallback) {
        service =RetrofitManger.instance.create(Service::class.java)
        service!!.RegisterService(phone,nickName,pwd)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Bean>(){
                override fun onComplete() {
                    println("sssssssssssssssssssssssssssssssssss")
                }

                override fun onNext(t: Bean) {
                    callba.SCSSESS(t)
                }

                override fun onError(e: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
    }




}