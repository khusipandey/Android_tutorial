package com.example.second_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.second_android.ui.theme.Second_AndroidTheme
//import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Second_AndroidTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Green
                        ),
                        modifier = Modifier
                            .size(width = 160.dp, height = 140.dp)
                    ) {
                        Text(text = "hello")
                    }

                    Button(
                        onClick = { /*TODO */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
                    ) {
                        Text("hello", color = Color.Green)
                    }
                    Button(
                        onClick = { /* TODO */ }
                    ) {
                        Text("Text Button")
                    }
                    Button(
                        onClick = { /*TODO */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
                    ) {
                        Icon(Icons.Filled.Add, "Floating action button.", tint = Color.Red)
                    }
                    Button(
                        onClick = { println("Iam clicked") },
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Red),
                    ) {
                        Text("Add to cart")
                    }
                    Button(
                        onClick = { println("Iam clicked") },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                    ) {
                        Icon(Icons.Rounded.ShoppingCart, contentDescription = " ")
                        Text("Add to cart")
                    }
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Second_AndroidTheme {
        Greeting("Android")
    }
}