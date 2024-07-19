package com.example.emailauthentication

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emailauthentication.ui.theme.EmailAuthenticationTheme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EmailAuthenticationTheme {
                LoginScreen()
            }
        }
    }
    val auth = FirebaseAuth.getInstance()
    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { task ->
                if (task.user != null) {
                    println("User Logged In")
                    var user = auth.currentUser
                    println(user?.uid)
                }
            }
    }
    fun signUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { task->

                if (task.user != null) {
                    println("User Created")
                    var user = auth.currentUser
                    println(user?.uid)
                }
            }
    }
    @Composable
    fun LoginScreen() {
        var email = remember { mutableStateOf("") }
        var password = remember { mutableStateOf("") }
        val activity = LocalContext.current as Activity

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text(" Enter Email") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Enter password") },
                modifier = Modifier.fillMaxWidth() ,
                visualTransformation = PasswordVisualTransformation()

            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick ={ signUp(email.value,password.value)}) {
                Text(text = "Register")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick ={ signIn(email.value,password.value)} ) {
                Text(text = "Login")
            }

        }
    }
}

