package com.example.second_android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.example.second_android.ui.theme.Second_AndroidTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.ui.graphics.RectangleShape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Second_AndroidTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(colors = CardDefaults.cardColors(containerColor = Color.Blue, contentColor = Color.Yellow),
                        modifier = Modifier
                            .size(width= 160.dp,height= 60.dp)) {
                        Text(text = "  I AM A CARD")
                        
                    }
                    val value = remember { mutableFloatStateOf(0f)  }
                    Slider(
                        value = value.value,
                        onValueChange = { value.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp))
                                Text(
                                text = "Value: ${value.value}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )
                    Divider(color=Color.Blue)

                    Button(
                        onClick = { /*TODO */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
                    ) {
                        Text("hello", color = Color.Green)
                    }
                    Divider(color=Color.Red)
                    Button(
                        onClick = { /* TODO */ }
                    ) {
                        Text("Text Button")
                    }
                    Divider(color=Color.Red)
                    Button(
                        onClick = { /*TODO */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
                    ) {
                        Icon(Icons.Filled.Add, "Floating action button.", tint = Color.Red)
                    }
                    Divider(color=Color.Red)
                    Button(
                        onClick = { println("Iam clicked") },
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(Color.Red),
                    ) {
                        Text("Add to cart")
                    }
                    Divider(color=Color.Red)
                    Button(
                        onClick = { println("Iam clicked") },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                    ) {
                        Icon(Icons.Rounded.ShoppingCart, contentDescription = " ")
                        Text("Add to cart")
                    }
                    Divider(color=Color.Red)
                    val checked = remember { mutableStateOf(true) }
                    Switch(
                        checked = checked.value ,
                        onCheckedChange = { checked.value = it },

                    )
                    Divider(color=Color.Red)
                    AssistChip(
                        onClick = { /*TODO*/ },
                        label = { Text("Assist chip") },
                    )
                    var selected = remember { mutableStateOf(false) }
                    FilterChip(selected = selected.value ,
                        onClick = { selected.value = !selected.value },
                        label = {
                            Text("Filter chip")
                        },
                        leadingIcon = if (selected.value) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon"
                                )
                            }
                        } else {
                            null
                        },
                    )
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
