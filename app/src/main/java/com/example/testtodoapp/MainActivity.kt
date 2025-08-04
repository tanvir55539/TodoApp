package com.example.testtodoapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.ui.Modifier


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

                    Column(modifier = Modifier.fillMaxSize()) {

//                       MyTopAppBar()
//                        FullTodoUi(todo_viewModel)
                        AppNavigation()

                    }

                }

            }
        }



