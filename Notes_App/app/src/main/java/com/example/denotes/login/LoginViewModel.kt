package com.example.denotes.login

import androidx.lifecycle.ViewModel
import com.example.denotes.repository.AuthRepository

class LoginViewModel(
    // Call the auth repository
    private val repository: AuthRepository = AuthRepository()
):ViewModel() {
}

// State for the login
data class LoginUiState(
    val userName:String = "",
    val password:String = "",
    val userNameSignUp:String = "",
    val passwordSignUp:String = "",
    val confirmpasswordSignUp:String = "",

    // States
    val isLoading:Boolean = false,
    val isSuccessLogin:Boolean = false,

    // Errors
    val signUpErrors:String? = null,
    val loginErrors:String? = null,

)