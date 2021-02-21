package com.yashanand.bodyfitness.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.yashanand.bodyfitness.R
import com.yashanand.bodyfitness.adapters.DailyExerciseAdapter
import kotlinx.android.synthetic.main.activity_daily_exercise.*

class DailyExercise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_exercise)

        findViewById<TextView>(R.id.running).setOnClickListener{ ToastMsg("Run daily at least 1 KM.") }
        findViewById<TextView>(R.id.drinking).setOnClickListener{ ToastMsg("Take water at least 7 liter daily") }
        findViewById<TextView>(R.id.breakfast).setOnClickListener{ //ToastMsg()
         }


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val items = fetchdata()
        recyclerView.adapter = DailyExerciseAdapter(this,items)
    }

    private fun fetchdata(): ArrayList<String> {
        val list= ArrayList<String>()
        for (i in 1..30){
            if(i%5==0){
                list.add("Day $i,Today is Rest.")
            }else {
                list.add("Day $i")
            }
        }
        return list
    }

    private fun ToastMsg(s: String) {
        /*val snackbar = Snackbar.make(it,"Run daily at least 1 KM.",Snackbar.LENGTH_SHORT).setAction("Action",null)
        snackbar.show()*/
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }


}


