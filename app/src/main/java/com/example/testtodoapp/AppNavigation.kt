package com.example.testtodoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testtodoapp.login.LoginScreen
import com.example.testtodoapp.login.LoginViewModel
import com.example.testtodoapp.signUp.SignUpScreen
import com.example.testtodoapp.signUp.SignUpViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(){
    val navcontroller = rememberNavController()

//    var context = LocalContext.current
//    val todoViewModel: TodoViewModel = viewModel()
    val loginViewModel : LoginViewModel = viewModel()
    val signUpViewModel : SignUpViewModel = viewModel()

    NavHost(navController = navcontroller, startDestination =  Routes.LoginScreen ) {

        composable( Routes.LoginScreen ) {
            LoginScreen(navcontroller,loginViewModel)
        }

        composable(Routes.signUp) {
            SignUpScreen(navcontroller,signUpViewModel)
        }

        composable(Routes.todoUi) {
//            FullTodoUi(viewModel =todoViewModel)
            TodoScreen()
        }


    }

}