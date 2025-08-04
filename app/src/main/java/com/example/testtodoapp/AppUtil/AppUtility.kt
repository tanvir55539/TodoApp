package com.example.testtodoapp.AppUtil

import android.widget.Toast
import android.content.Context
object AppUtility {
    fun showToast(context: Context,message: String){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
    }

}