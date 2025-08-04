//package com.example.testtodoapp
//
//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.CenterAlignedTopAppBar
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.room.util.getColumnIndex
//import java.text.SimpleDateFormat
//import java.util.Locale
//
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun TodoScreen(){
//    val todoViewModel: TodoViewModel = viewModel()
//    Column {
//        MyTopAppBar()
//        FullTodoUi(todoViewModel)
//    }
//
//}
//
//
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun FullTodoUi(viewModel: TodoViewModel){
//
//
//    val context = LocalContext.current
//
//    val todoList by viewModel.todoList.collectAsState()
//
//
//    var inputText by remember {
//        mutableStateOf("")
//    }
//
//    Column(modifier = Modifier
//        .padding(8.dp)
//        .fillMaxSize()
//        ) {
//
//        Row(modifier = Modifier.padding(8.dp),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//
//            OutlinedTextField(
//                value = inputText,
//                onValueChange = {inputText=it},
//                modifier = Modifier.weight(1f)
//            )
//
//            Spacer(modifier = Modifier.padding(4.dp))
//
//            Button(onClick = {
//                viewModel.addTodo(inputText, context)
//                inputText=""
//            }) {
//                Text(text = "Add")
//            }
//
//        }
//
////        EachTodoUi(item = Todo )
//
//        if(todoList == emptyList<Todo>()){
//         Column(horizontalAlignment = Alignment.Start,
//             verticalArrangement = Arrangement.Center,
//             modifier = Modifier.fillMaxSize()) {
//             Text(text = "No items yet",
//                 modifier = Modifier.fillMaxWidth(),
//                 textAlign = TextAlign.Center,
//                 fontSize = 16.sp,
//             )
//         }
//        }
//        else{
//            LazyColumn (content = {
//                itemsIndexed(todoList) { index : Int, items: Todo ->
//                    EachTodoUi(item = items , onDelete = {
//                        viewModel.deleteTodo(items.id)
//                    }
//                    )
//                }
//
//            }
//            )
//        }
//
//    }
//
//}
//
//
//
//
//
//@Composable
//fun EachTodoUi(item: Todo , onDelete : ()-> Unit) {
//
//    Row(
//        modifier=Modifier.fillMaxWidth()
//            .padding(8.dp)
//            .clip(RoundedCornerShape(24.dp) )
//            .background(MaterialTheme.colorScheme.primary)
//            .padding(16.dp)
//    ) {
//        Column( modifier = Modifier.weight(1.0f)
//        ) {
//            var dateFormate = SimpleDateFormat("hh:mm a, dd/MM/yyyy", Locale.ENGLISH)
//
//            Text(text = item.title,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.SemiBold,
//                color = Color.White,
//                modifier = Modifier.padding(8.dp)
//
//            )
//
//            Text(text = dateFormate.format(item.date),
//                color = Color.Gray)
//        }
//
//        IconButton(onClick = onDelete) {
//            Icon(painter = painterResource(id = R.drawable.baseline_delete_24),
//                contentDescription = "Delete Button",
//                tint = Color.White,
//
//                )
//        }
//
//
//    }
//
//
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyTopAppBar(){
//    CenterAlignedTopAppBar(
//        title = {
//            Text(
//                text = "ToDo List",
//                fontWeight = FontWeight.Bold,
//                fontSize = 24.sp
//            )
//        },
//        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
//            containerColor = Color.Gray,
//            titleContentColor = Color.White
//        ),
//        windowInsets = TopAppBarDefaults.windowInsets
//    )
//}
//
//


package com.example.testtodoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
//import androidx.compose.material3.icons.Icons
//import androidx.compose.material3.icons.filled.Notes
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.text.SimpleDateFormat
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoScreen() {
    val todoViewModel: TodoViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color(0xFFE3F2FD), Color(0xFF90CAF9))
                )
            )
    ) {
        MyTopAppBar()
        FullTodoUi(todoViewModel)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FullTodoUi(viewModel: TodoViewModel) {
    val context = LocalContext.current
    val todoList by viewModel.todoList.collectAsState()

    var inputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp)),
                placeholder = { Text("Enter your task...") },
                singleLine = true
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    viewModel.addTodo(inputText, context)
                    inputText = ""
                },
                modifier = Modifier.height(56.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Add")
            }
        }

        if (todoList.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_empty_state),
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "No tasks yet!",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
            }
        } else {
            LazyColumn {
                itemsIndexed(todoList) { _, item ->
                    AnimatedVisibility(visible = true) {
                        EachTodoUi(
                            item = item,
                            onDelete = { viewModel.deleteTodo(item.id) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EachTodoUi(item: Todo, onDelete: () -> Unit) {
    val dateFormat = SimpleDateFormat("hh:mm a, dd/MM/yyyy", Locale.ENGLISH)

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Text(
                    text = dateFormat.format(item.date),
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 12.sp
                )
            }

            IconButton(onClick = onDelete) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_delete_24),
                    contentDescription = "Delete",
                    tint = Color.White
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "ToDo List",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_note),
                contentDescription = "App Icon",
                tint = Color.White,
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        ),
        windowInsets = TopAppBarDefaults.windowInsets
    )
}
