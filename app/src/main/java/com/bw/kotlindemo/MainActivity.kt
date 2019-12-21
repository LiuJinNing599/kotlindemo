package com.bw.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bw.kotlindemo.contract.IBack
import com.bw.kotlindemo.presenter.LoginPresenter
import com.bw.kotlindemo.util.RsaCoder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),IBack.IView {

private var presenter :LoginPresenter ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = LoginPresenter(this)

        btn_login.setOnClickListener {
            val id = login_id.text.toString()
            val pass = login_pwd.text.toString();
            if (id.equals("") ||pass.equals("")){
                Toast.makeText(this,"账号密码不能为空",Toast.LENGTH_SHORT).show()
            }else{

                val byPublicKey = RsaCoder.encryptByPublicKey(pass);
                presenter!!.getrpesenter(id,byPublicKey)
            }
        }

        btn_regirst.setOnClickListener {
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        }
    }

    override fun Desuccess(loginBean: LoginBean) {
        val loginBean1 = loginBean as LoginBean
        val message = loginBean1.message;
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        if (loginBean1.status.equals("0000")){
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }

    override fun Deerror(e: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
