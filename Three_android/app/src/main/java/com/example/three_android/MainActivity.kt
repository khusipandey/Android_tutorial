package com.example.three_android

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.res.vectorResource
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.three_android.ui.theme.Three_androidTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Three_androidTheme {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 1.dp)
                ) {
                    Card(

                        modifier = Modifier
                            .size(width = 400.dp, height = 540.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = " Jetpack Compose ",
                                modifier = Modifier
                                    .padding(16.dp)
                                    .align(Alignment.CenterHorizontally),
                                style = TextStyle(
                                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                                    fontWeight = FontWeight.Bold
                                ),
                                color = Color(0xFF074f8a),
                                textAlign = TextAlign.Center,
                            )
                        }
                        Spacer(modifier = Modifier.height(1.dp))
                        Image(
                            painter = painterResource(id = R.drawable.jetpack_compose),
                            contentDescription = "My Image",
                            modifier = Modifier
                                .size(100.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Text(
                            text = "Login",
                            modifier = Modifier
                                .padding(16.dp),
                            style = TextStyle(
                                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                                fontWeight = FontWeight.Bold
                            ),
                            color = Color(0xFF036a3a),
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        OutlinedTextField(
                            value = "",
                            onValueChange = { },
                            label = { Text("Email ID or Mobile  Number") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        var password = remember { mutableStateOf("") }
                        var passwordVisibility = remember { mutableStateOf(false) }
                        OutlinedTextField(
                            value = password.value,
                            onValueChange = { password.value = it },
                            label = { Text("Password") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                IconButton(onClick = {
                                    passwordVisibility.value = !passwordVisibility.value
                                }) {

                                    Image(
                                        painter = painterResource(id = if (passwordVisibility.value) R.drawable.visibility_on else R.drawable.visibility_off),
                                        contentDescription = "Toggle password"
                                    )

                                }
                            }
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 1.dp), horizontalArrangement = Arrangement.End
                        )
                        {
                            Text("Forgot Password ? ", color = Color(0xFF074f8a))
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Button(
                            onClick = { "I am clicked" },
                            modifier = Modifier
                                .size(width = 160.dp, height = 50.dp)
                                .padding(horizontal = 16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF074f8a))
                        ) {
                            Text("Login")
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ){

                    Text(
                        buildAnnotatedString {
                            append("Don't have an account? ")
                            withStyle(
                                SpanStyle(color = Color.Blue)
                            ) {
                                append("Sign up")
                            }


                        }
                    )}

                }}
            }
        }
    }




