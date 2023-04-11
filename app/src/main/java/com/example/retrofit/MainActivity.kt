package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val qoutesAPI =  RetrofitHelper.getInstance().create(QoutesAPI::class.java)
        GlobalScope.launch {
            val result = qoutesAPI.getQoutes(1)
            if (result != null){
                Log.d("UsmanCode",result.body().toString())
                val qouteList = result.body()
                qouteList!!.results.forEach{
                    Log.d("UsmanCode2",it.content)
                }
            }
        }
    }
}