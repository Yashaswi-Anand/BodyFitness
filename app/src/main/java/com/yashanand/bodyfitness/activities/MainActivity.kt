package com.yashanand.bodyfitness.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.yashanand.bodyfitness.LoginActivity
import com.yashanand.bodyfitness.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        //val imageview = findViewById<ImageView>(R.id.gif_image)
        val url = "https://images.unsplash.com/photo-1597448969266-0712c1de0c8c?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
        //Glide.with(this).load(url).into(imageview)
        //Glide.with(this).asGif().load(url).into(imageview)
         Handler().postDelayed({
             startActivity(Intent(this, LoginActivity::class.java))
             finish()
         }, 2000)
    }
}