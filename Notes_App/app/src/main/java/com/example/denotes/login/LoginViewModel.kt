package com.example.denotes.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.denotes.repository.AuthRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    // Call the auth repository
    private val repository: AuthRepository = AuthRepository()
):ViewModel() {


    // Get user
    val currentUser = repository.currentUser

    val hasUser: Boolean
        get() = repository.hasUser()

    // The state
    var loginUiState by mutableStateOf(LoginUiState())
        private set

    // Events modifying the state
    fun onUsernameChange(userName: String) {
        loginUiState = loginUiState.copy(userName = userName)
    }
    fun onPasswordChange(password: String) {
        loginUiState = loginUiState.copy(password = password)
    }
    fun onUsernameSignupChange(userName: String) {
        loginUiState = loginUiState.copy(userNameSignUp = userName)
    }
    fun onPasswordSignUpChange(password: String) {
        loginUiState = loginUiState.copy(passwordSignUp = password)
    }
    fun onConfirmPasswordSignUpChange(password: String) {
        loginUiState = loginUiState.copy(confirmpasswordSignUp = password)
    }

    // Validate the signup and login forms
    // Login form validation
    private fun validateLoginForm() =
        loginUiState.userName.isNotBlank() &&
                loginUiState.password.isNotBlank()
    // End of login form validation

    // Signup form validation
    private fun validateSignUpForm() =
        loginUiState.userNameSignUp.isNotBlank() &&
                loginUiState.passwordSignUp.isNotBlank() &&
                loginUiState.confirmpasswordSignUp.isNotBlank()
    // End of signup form validation

    // To create user
    fun createUser(context: Context) = viewModelScope.launch {
        try {
            // Confirm signup fields aren't empty
            if (!validateSignUpForm()) {
                throw IllegalArgumentException("The fields cannot be empty")
            }
            loginUiState = loginUiState.copy(isLoading = true)
            if (loginUiState.passwordSignUp !=
                    loginUiState.confirmpasswordSignUp) {
                throw IllegalArgumentException("Passwords do not match")
            }
            loginUiState = loginUiState.copy(signUpErrors = null)
            // Create user
            repository.createUser(
                loginUiState.userNameSignUp,
                loginUiState.passwordSignUp,
            ){isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(context,"Login success",Toast.LENGTH_SHORT).show()
                    loginUiState = loginUiState.copy(isSuccessLogin = true)
                }else{
                    Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
                    loginUiState = loginUiState.copy(isSuccessLogin = false)
                }

            }
        }catch (e:Exception) {
            loginUiState = loginUiState.copy(signUpErrors = e.localizedMessage)
            e.printStackTrace()
        }finally {
            // Disable the loading progress bar
            loginUiState = loginUiState.copy(isLoading = false)
        }
    }

    // To login user
    fun loginUser(context: Context) = viewModelScope.launch {
        try {
            // Confirm signup fields aren't empty
            if (!validateLoginForm()) {
                throw IllegalArgumentException("The fields cannot be empty")
            }
            loginUiState = loginUiState.copy(isLoading = true)
            loginUiState = loginUiState.copy(loginErrors = null)
            // Create user
            repository.loginUser(
                loginUiState.userName,
                loginUiState.password,
            ){isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(context,"Login success",Toast.LENGTH_SHORT).show()
                    loginUiState = loginUiState.copy(isSuccessLogin = true)
                }else{
                    Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
                    loginUiState = loginUiState.copy(isSuccessLogin = false)
                }

            }
        }catch (e:Exception) {
            loginUiState = loginUiState.copy(loginErrors = e.localizedMessage)
            e.printStackTrace()
        }finally {
            // Disable the loading progress bar
            loginUiState = loginUiState.copy(isLoading = false)
        }
    }




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