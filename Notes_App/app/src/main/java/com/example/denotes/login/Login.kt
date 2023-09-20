package com.example.denotes.login

import android.graphics.pdf.PdfDocument.Page
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.denotes.ui.theme.DeNotesTheme

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel? = null,
    onNavToHomePage: () -> Unit,
    onNavToSignUpPage: () -> Unit,
){
    // Get login state
    val loginUiState = loginViewModel?.loginUiState

    // Check if there's an error
    val isError = loginUiState?.loginErrors != null

    // Get the current context
    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) 
    {
        Text(
            text = "Login",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Black,
        )
        // Display error
        if (isError) {
            Text(
                text = loginUiState?.loginErrors ?: "Unknown error",
                color = Color.Red,
            )
        }




    }
}

//Preview function
@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen() {
    DeNotesTheme() {
        LoginScreen(onNavToHomePage = { /*TODO*/ }) {
            
        }
    }
}