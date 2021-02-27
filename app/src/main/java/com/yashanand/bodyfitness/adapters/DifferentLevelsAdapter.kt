package com.yashanand.bodyfitness.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yashanand.bodyfitness.DashboardActivity
import com.yashanand.bodyfitness.activities.DailyExercise
import com.yashanand.bodyfitness.R
import com.yashanand.bodyfitness.models.LevelModel

class DifferentLevelsAdapter(var context: Context,val itemList: ArrayList<LevelModel>):
    RecyclerView.Adapter<DifferentLevelsAdapter.ViewPager_ViewHolder>() {

    inner class ViewPager_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPager_ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.level_items,parent,false)
        return  ViewPager_ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPager_ViewHolder, position: Int) {
        val  items = itemList[position]
        val image = holder.itemView.findViewById<ImageView>(R.id.img)
        Glide.with(context).load(items.image).into(image)
        holder.itemView.findViewById<TextView>(R.id.txt).text = items.LevelType
        holder.itemView.findViewById<TextView>(R.id.descriptions).text = items.LevelDescription
        holder.itemView.findViewById<Button>(R.id.btn_level).setOnClickListener{
            Toast.makeText(context,"I am ready to exercise",Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, DashboardActivity::class.java))

        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}