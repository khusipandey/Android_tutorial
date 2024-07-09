package com.example.four_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.four_android.ui.theme.Four_androidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                CounterView()
            }





        }

        }@Composable
    fun CounterView(counterVM : CounterViewModel= viewModel( )) {
        val counterstate = counterVM.counter.value
        var intContent = GenericClass("hi")
        var strContent = GenericClass(2)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Current counter value : ${counterstate.count}")
            Row {
                Button(onClick = { counterVM.incrementCounter() }) {
                    Text(text = "INCREMENT")
                }
                Spacer(modifier = Modifier.size(15.dp))
                Button(onClick = { counterVM.decrementCounter() }) {
                    Text(text = "DECREMENT")
                }

            }
            Button(onClick = { counterVM.resetCounter() }) {
                Text(text = "RESET")
            }
            Button(onClick = { println(intContent.content )
                println(strContent.content)
            }) {
                Text(text = "GENERIC")
            }


        }
    }
}
//model class
data class Counter(val count:Int)
data class User(val username: String, val  password: String)

//viewmodel

class CounterViewModel : ViewModel() {
    private  val _counter = mutableStateOf(Counter(0))
    val counter: State<Counter> =_counter
    fun incrementCounter(){
        _counter.value = Counter(_counter.value.count +1)
    }
    fun decrementCounter()
    {
        _counter.value = Counter(_counter.value.count -1)
    }
    fun resetCounter()
    {
        _counter.value = Counter(0)
    }


}

//GENERIC CLASS
class GenericClass<T> (var content: T)
{

}


























