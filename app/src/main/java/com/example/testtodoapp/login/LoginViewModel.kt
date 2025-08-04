package com.example.testtodoapp.login

import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel: ViewModel() {

//    private val _email = MutableStateFlow("")
//    val email: StateFlow<String> = _email
//
//    fun onUpdateEmail(newEmail: String) {
//        _email.value = newEmail
//    }
//
//    private val _pass = MutableStateFlow("")
//    val pass : StateFlow<String> = _pass
//
//    fun onPassUpdate(newPass : String){
//        _pass.value = newPass
//    }


    private val auth = Firebase.auth

    fun login(email: String, pass: String,onResult:(Boolean, String?)-> Unit){

        auth.signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    onResult(true,null)
                }else{
                    onResult(false, it.exception?.localizedMessage)
                }
            }


    }



}