package com.example.testtodoapp.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.testtodoapp.AppUtil.AppUtility
import com.example.testtodoapp.Routes
import com.example.testtodoapp.R



@Composable
fun LoginScreen(navController: NavController, LoginViewModel: LoginViewModel){


// instead of this variable declaration individually use viewModel
    var email by remember {
        mutableStateOf("")
    }

    var pass by remember {
        mutableStateOf("")
    }

    var context = LocalContext.current


//    val email by viewModel.email.collectAsState()
//    val pass by viewModel.pass.collectAsState()


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(painter = painterResource(R.drawable.img) ,
            contentDescription = "login image",
            modifier = Modifier.size(200.dp)

        )


        Text(text = "Welcome Back", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Login to Your Account")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange = {email = it}, label = {
            Text(text = "Email Address")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = pass, onValueChange = {pass = it}, label = {
            Text(text = "Password")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {

            if(email.isEmpty() || pass.isEmpty()){
                Toast.makeText(context,"Enter email and Password",Toast.LENGTH_SHORT).show()

            }else{
                LoginViewModel.login(email,pass){ success, errorMessage->
                    if(success){
//
                        navController.navigate(Routes.todoUi){
                            popUpTo(Routes.LoginScreen){inclusive = true}
                        }

                    }else{
//
                        AppUtility.showToast(context,errorMessage?:"Something went wrong")
                    }
                }

            }


//            navController.navigate(Routes.todoUi)


        }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(20.dp))


        TextButton(onClick = {}) {
            Text(text = "Forget Password?")
        }

        Text(text = "or SignIn with Email",
            color = Color.Magenta,
            modifier = Modifier.clickable{

                navController.navigate(Routes.signUp)


            })

    }



}