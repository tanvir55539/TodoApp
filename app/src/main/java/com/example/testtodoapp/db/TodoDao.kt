package com.example.testtodoapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtodoapp.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("Select * From todoDB")
    fun getAllTodo(): Flow<List<Todo>>

    // avoid duplicates todo
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTodo(todo: Todo)

    @Query("SELECT COUNT(*) FROM todoDB WHERE title = :text")
    suspend fun countByText(text: String): Int

    @Query("Delete From todoDB Where id = :id")
    fun deleteTodo(id:Int)


}