package com.example.testtodoapp

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.Instant
import java.util.Date
import kotlin.compareTo

class TodoViewModel: ViewModel() {

//    private val _todoList = MutableStateFlow<List<Todo>>(emptyList())
//    var todoList : StateFlow<List<Todo>> = _todoList
//
//
//    fun showTodo(){
//       _todoList.value = todoRepository.showTodo()
//
//    }
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun addTodo(title: String){
//        todoRepository.addTodo(title)
//        showTodo()
//    }
//
//    fun deleteTodo(id:Int){
//
//        todoRepository.deleteTodo(id)
//        showTodo()
//    }


    val todoDao = MainApplication.todoDataBase.getTodoDao()

    val todoList: StateFlow<List<Todo>> = todoDao.getAllTodo()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

//    val todoList: Flow<List<Todo>> = todoDao.getAllTodo()


    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String, context: Context) {

        viewModelScope.launch {
            val trimmedTitle = title.trim()

            // Check for empty todo
            if (trimmedTitle.isEmpty()) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Todo cannot be empty", Toast.LENGTH_SHORT).show()
                }
                return@launch
            }

            // Check for duplicate
            val isDuplicate = todoDao.countByText(trimmedTitle) > 0
            if (isDuplicate) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Todo already exists", Toast.LENGTH_SHORT).show()
                }
                return@launch
            }

            // Insert valid todo
            val todo = Todo(title = trimmedTitle, date = Date.from(Instant.now()))
            todoDao.addTodo(todo)

            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Todo added successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun deleteTodo(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(id)
        }
    }

}