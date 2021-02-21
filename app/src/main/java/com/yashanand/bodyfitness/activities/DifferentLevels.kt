package com.yashanand.bodyfitness.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.yashanand.bodyfitness.R
import com.yashanand.bodyfitness.adapters.DifferentLevelsAdapter
import com.yashanand.bodyfitness.models.LevelModel
import java.util.ArrayList

class DifferentLevels : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_differents_level)

        var listOfItems : ArrayList<LevelModel>? =null
        listOfItems = ArrayList()
        listOfItems.add(LevelModel("Beginner","Start for 1 month only","https://previews.123rf.com/images/vadymvdrobot/vadymvdrobot1509/vadymvdrobot150900425/45024738-portrait-of-a-handsome-fitness-man-standing-at-gym-and-looking-at-camera.jpg"))
        listOfItems.add(LevelModel("Intermediate","Start for 2 month only","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpbcJ6lBiA7U03EbHryT35twziCbtruXICkA&usqp=CAU"))
        listOfItems.add(LevelModel("Advance","Start for 3 month only","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFBt8QOvJRt6ETMDD3k662Usi4NY5Teg-gVA&usqp=CAU"))

        val adapter = DifferentLevelsAdapter(this,listOfItems)
        val viewpager = findViewById<ViewPager2>(R.id.level_viewpager2)
        viewpager.adapter = adapter

        //viewpager.orientation = ViewPager2.ORIENTATION_VERTICAL //  convert view pager default to vertically like tiktok
    }
}