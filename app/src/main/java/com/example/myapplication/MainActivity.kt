package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
//
       setContentView(R.layout.activity_main)

     image.translationY = -1000f
        image2.translationY = -1000f

        tx1.translationY = -600f
        btn1.translationY = 500f
        tx3.translationY = 500f


        tx1.animate().translationY(0f).duration = 400

        image.animate().translationY(0f).duration = 1000
        image2.animate().translationY(0f).duration = 1500

        btn1.animate().translationY(0f).duration = 1700
        tx3.animate().translationY(0f).duration = 1700

        btn1.setOnClickListener{
            val intent= Intent(this,NewBackendActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        finishAffinity()
    }
}