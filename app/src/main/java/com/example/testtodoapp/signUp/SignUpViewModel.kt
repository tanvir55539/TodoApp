package com.example.testtodoapp.signUp

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.example.testtodoapp.model.userModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.firestoreSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignUpViewModel: ViewModel() {
//
//    private val _email = MutableStateFlow("")
//    val email: StateFlow<String> = _email
//
//    fun onUpdateEmail(newEmail: String) {
//        _email.value = newEmail
//    }
//
//
//    private val _name = MutableStateFlow("")
//    val name: StateFlow<String> = _name
//
//    fun onNameUpdate(newName: String){
//        _name.value = newName
//    }
//
//    private val _pass = MutableStateFlow("")
//    val pass : StateFlow<String> = _pass
//
//    fun onPassUpdate(newPass : String){
//        _pass.value = newPass
//    }


    private val auth = Firebase.auth
    private val firestore = Firebase.firestore

    @SuppressLint("SuspiciousIndentation")
    fun signUp(email: String, name: String, password: String, onResult:(Boolean, String?)-> Unit){
       auth.createUserWithEmailAndPassword(email,password)
           .addOnCompleteListener {
               if (it.isSuccessful){

                 var userId = it.result?.user?.uid
                 val userModel = userModel(name,email, userId!!) //this user id is provided by firebase so it can't be null that's why ( usedId!!) is used
                   firestore.collection("users").document(userId)
                       .set(userModel)
                       .addOnCompleteListener { dbTask ->
                           if(dbTask.isSuccessful){
                               onResult(true,null)
                           }else{
                               onResult(false,"Some went Wrong!!")
                           }

                       }
               }else{
                   onResult(false, it.exception?.localizedMessage)
               }
           }

    }


}