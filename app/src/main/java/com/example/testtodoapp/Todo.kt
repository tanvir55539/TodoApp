package com.example.testtodoapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "todoDB")
data class Todo(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var date: Date,
)

//data class Todo(
//
//    var id: Int = 0,
//    var title: String,
//    var date: Date,
//)
