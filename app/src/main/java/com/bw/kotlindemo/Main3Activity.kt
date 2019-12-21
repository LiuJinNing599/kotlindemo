package com.bw.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bw.kotlindemo.contract.IBackZhuce
import com.bw.kotlindemo.presenter.LoginPresenter
import com.bw.kotlindemo.presenter.RegisterPresenter
import com.bw.kotlindemo.util.RsaCoder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() ,IBackZhuce.IView {

    private var presenter : RegisterPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        presenter = RegisterPresenter(this)

        regirst.setOnClickListener {
            val id = shou.text.toString()
            val pass = pwd.text.toString();
            val name =name.text.toString()
            if (id.equals("") ||pass.equals("") || name.equals("")){
                Toast.makeText(this,"账号密码不能为空", Toast.LENGTH_SHORT).show()
            }else{

                val byPublicKey = RsaCoder.encryptByPublicKey(pass);
                presenter!!.getrpesenter(id,name,byPublicKey)
            }
        }
    }

    override fun Desuccess(bean: Bean) {
        val loginBean1 = bean as Bean
        val message = loginBean1.message;
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

    }

    override fun Deerror(e: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
