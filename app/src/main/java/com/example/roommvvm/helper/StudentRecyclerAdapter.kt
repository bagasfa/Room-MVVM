package com.example.roommvvm.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roommvvm.R
import com.example.roommvvm.entity.Student
//Membuat adapter recycler view yang berguna untuk menampung data dan ditampilkan seperti list view
class StudentRecyclerAdapter(private val myDataset: List<Student>):
        RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        mendeklarasikan variabel tvName
        var tvName: TextView = itemView.findViewById(R.id.tvName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
//        membuat konstanta view untuk Layout activity recyler_item
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)

//        mengembalikan nilai konstanta v
        return StudentViewHolder(v)
    }

//    membuat fungsi perhitungan data
    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.tvName.text = myDataset[position].name
    }
}