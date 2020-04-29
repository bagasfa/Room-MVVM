package com.example.roommvvm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Digunakan untuk menentukan kebutuhan pada suatu tabel

@Entity
//Membuat class data Student
data class Student (
//  Menentukan id sebagai primary key, dan auto increment
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
//Menentukan tipe data pada field name
    @ColumnInfo var name: String = ""
)