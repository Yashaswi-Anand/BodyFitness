package com.yashanand.bodyfitness

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yashanand.bodyfitness.fragments.Challenge
import com.yashanand.bodyfitness.fragments.Chat
import com.yashanand.bodyfitness.fragments.Tutorial
import kotlinx.android.synthetic.main.activity_dashboard.*


class DashboardActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var bottom_nav = findViewById<BottomNavigationView>(R.id.BottomMenu)
        var frame = findViewById<FrameLayout>(R.id.frameLayout)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Challenge()).commit()

        bottom_nav.setOnNavigationItemSelectedListener{ item ->
            when(item.itemId){
                R.id.challenge ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Challenge()).commit()
                    supportActionBar?.hide()
                }
                R.id.chat ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Chat()).commit()
                    supportActionBar?.hide()
                }
                R.id.tutorial ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Tutorial()).commit()
                    supportActionBar?.hide()
                }
            }

            return@setOnNavigationItemSelectedListener true
        }

    }
}



