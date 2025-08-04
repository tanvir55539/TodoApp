package com.example.testtodoapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testtodoapp.Todo


@Database(entities = [Todo::class], version = 1)
@TypeConverters(Converter::class)

abstract class TodoDataBase : RoomDatabase(){

    companion object{
        const val Name = "todoDB"
    }

    abstract fun getTodoDao(): TodoDao

}