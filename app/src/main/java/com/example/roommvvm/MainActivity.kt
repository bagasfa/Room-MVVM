package com.example.roommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roommvvm.fragment.NameListFragment
import com.example.roommvvm.fragment.NewNameFragment
import timber.log.Timber

class MainActivity : AppCompatActivity(),
    NewNameFragment.OnFragmentInteractionListener,
    NameListFragment.OnFragmentInteractionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
//            melakukan eksekusi fungsi
            goToStudentListFragment()
        }

//        menciptakan log menggunakan library dari timber
        Timber.plant(Timber.DebugTree())
    }

//    membuat fungsi goToStudentListFragment
    override fun goToStudentListFragment() {
//    membuat dua konstanta
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
//    memulai transaksi untuk berpindah ke fragment lainnya
        transaction.replace(R.id.flContent, NameListFragment.newInstance())
        transaction.commit()
    }

//    membuat fungsi goToNewNameFragment
    override fun goToNewNameFragment() {
//    membuat dua konstanta
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
//    memulai transaksi untuk berpindah ke fragment lainnya
        transaction.replace(R.id.flContent, NewNameFragment.newInstance())
        transaction.commit()
    }
}
