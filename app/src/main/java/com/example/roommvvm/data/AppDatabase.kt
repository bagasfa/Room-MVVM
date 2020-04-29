package com.example.roommvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roommvvm.dao.StudentDao
import com.example.roommvvm.entity.Student

//Membuat database dengan tabel/entity Student yang ada pada class Student.kt
@Database(entities = arrayOf(Student::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
//    membuat fungsi abstrak dari class StudentDao
    abstract fun studentDao(): StudentDao

    companion object {
//        mendeklarasikan variabel INSTANCE
        private var INSTANCE: AppDatabase? = null

//        membuat fungsi getInstance
        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "student-database")
                        .build()
                }
            }
//            mengembalikan nilai dari variabel INSTANCE
            return INSTANCE
        }

//        fungsi untuk menghapus
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}