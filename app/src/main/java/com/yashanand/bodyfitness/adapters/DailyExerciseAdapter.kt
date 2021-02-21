package com.yashanand.bodyfitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.yashanand.bodyfitness.R


class DailyExerciseAdapter(var context: Context, val items:ArrayList<String>): RecyclerView.Adapter<DailyExerciseAdapter.dailyExrecise>() {

    inner class dailyExrecise(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dailyExrecise {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dailyexercise_item,parent,false)
        return dailyExrecise(view)
    }

    override fun onBindViewHolder(holder: dailyExrecise, position: Int) {
        var item = items[position]
        holder.itemView.findViewById<TextView>(R.id.daily_item).text = item
        holder.itemView.findViewById<CardView>(R.id.daily_cardview_item).setOnClickListener {
            Toast.makeText(context,"move to next page.",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

