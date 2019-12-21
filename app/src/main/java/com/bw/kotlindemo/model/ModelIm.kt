package com.bw.kotlindemo.model

import com.bawei.kotlin.network.RetrofitManger
import com.bw.kotlindemo.LoginBean
import com.bw.kotlindemo.Service
import com.bw.kotlindemo.contract.IBack
import com.bw.kotlindemo.contract.LoginCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**

 *Time:2019/12/20 16:50
 *Author:刘瑾宁
 *Description:
 */
class ModelIm  : IBack.IModel{

    private var  service : Service ?=null

    override fun getmodel(phone: String, pwd: String, callba: LoginCallback) {
        service =RetrofitManger.instance.create(Service::class.java)
        service!!.LoginService(phone,pwd)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<LoginBean>(){
                override fun onComplete() {
                    println("sssssssssssssssssssssssssssssssssss")
                }

                override fun onNext(t: LoginBean) {
                   callba.SCSSESS(t)
                }

                override fun onError(e: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })

    }


}