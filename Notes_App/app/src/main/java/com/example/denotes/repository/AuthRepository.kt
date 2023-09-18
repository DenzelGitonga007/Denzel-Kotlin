package com.example.denotes.repository

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class AuthRepository {

    // Declare the Firebase.auth.currentUser object
    val FirebaseUser = Firebase.auth.currentUser
    // Check the current user
    val currentUser:FirebaseUser? = FirebaseUser

    // Function to check if user is logged in
    fun hasUser():Boolean = FirebaseUser != null

    // Get the user id
    fun getId():String = FirebaseUser?.uid.orEmpty()

    //create user
    suspend fun createUser(
        email:String,
        password:String,
        onComplete:(Boolean) ->Unit
    ) = withContext(Dispatchers.IO) {
        Firebase.auth
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (it.isSuccessful) {
                    onComplete.invoke(true)
                }else{
                    onComplete.invoke(false)
                }
            }.await()
    }

    //login user
    suspend fun loginUser(
        email:String,
        password:String,
        onComplete:(Boolean) ->Unit
    ) = withContext(Dispatchers.IO) {
        Firebase.auth
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (it.isSuccessful) {
                    onComplete.invoke(true)
                }else{
                    onComplete.invoke(false)
                }
            }.await()
    }







}