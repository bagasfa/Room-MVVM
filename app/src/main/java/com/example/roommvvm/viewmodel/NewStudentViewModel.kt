package com.example.roommvvm.viewmodel

import android.app.Application
import android.graphics.Movie
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roommvvm.data.AppDatabase
import com.example.roommvvm.entity.Student
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class NewStudentViewModel(application: Application) : AndroidViewModel(application) {
//    mendeklarasikan konstanta mDb dan allStudent
    private val mDb: AppDatabase? = AppDatabase.getInstance(application)
    private val allStudent = MutableLiveData<List<Student>>()

//    membuat fungsi store data
    fun storeMovie(title: String) {

//    mendeklarasikan konstanta student
        val student = Student()
        student.name = title

        GlobalScope.launch {
//            perintah insert data pada Dao
            mDb?.studentDao()?.insertStudent(student)
        }
    }

    fun retrieveStudent(): LiveData<List<Student>> {

        GlobalScope.launch {
//            membuat konstanta list
            val list = mDb?.studentDao()?.getAll()

//            menghitung data yang ada pada database
            Timber.i("Data yang ada sejumlah {${list?.size}}")
            allStudent.postValue(list)
        }

//        mengembalikan nilai dari allStudent
        return allStudent
    }
}