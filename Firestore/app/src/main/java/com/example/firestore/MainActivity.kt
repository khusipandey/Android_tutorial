package com.example.firestore

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.firestore.ui.theme.FirestoreTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            FirestoreTheme {
                LoginScreen()
            }
        }
    }
        val db= Firebase.firestore
        fun addEmp(name: String ,id: Int,dept: String ){
            val emp= Emp(name,id,dept)
            db.collection("user")
                .document(id.toString())    //to give id as uid in firestore db
                .set(emp)


            db.collection("Employee")
                .add(emp)                  // here a uid will be generated by firestore db
                .addOnSuccessListener { docRef ->
                    Log.d(TAG, "DOCUMENT SNAPSHOT ADDED WITH ID : ${docRef.id}")
                }
                .addOnFailureListener{ e->
                    Log.w(TAG, "Error adding employee")
                }
        }
        fun updateEmp(name: String, id: Int, dept: String) {
            val emp = Emp(name, id, dept)
            db.collection("Employee")
            .whereEqualTo("id", id)      // Find the document with the given id in the Employee collection
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    db.collection("Employee").document(document.id).set(emp)
                        .addOnSuccessListener {
                            Log.d(TAG, "DOCUMENT UPDATED IN EMPLOYEE COLLECTION WITH ID: ${document.id}")
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error updating employee", e)
                        }
                }
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error finding employee document", e)
            }
    }
    fun deleteEmp(id: Int) {

        db.collection("Employee")
            .whereEqualTo("id", id)      // Find the document with the given id in the Employee collection
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    db.collection("Employee").document(document.id).delete()
                        .addOnSuccessListener {
                            Log.d(TAG, "DOCUMENT DELETED IN EMPLOYEE COLLECTION WITH ID: ${document.id}")
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error deleting employee", e)
                        }
                }
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error finding employee document", e)
            }
    }
    fun fetchEmp(id: Int, onResult: (Emp?) -> Unit) {
        db.collection("Employee")
            .document(id.toString()) // assuming the document id is the employee id
            .get()
            .addOnSuccessListener { document ->
                if (document != null && document.exists()) {
                    val emp = document.toObject(Emp::class.java)
                    onResult(emp)
                } else {
                    onResult(null)
                }
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error fetching employee", e)
                onResult(null)
            }
    }




    @Composable
        fun LoginScreen()
        {
            val name = remember{ mutableStateOf("") }
            val id = remember{ mutableStateOf("") }
            val dept = remember{ mutableStateOf("") }
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                modifier = Modifier
                    .size(width = 400.dp, height = 600.dp)
            ) {
                Spacer(modifier = Modifier.height(120.dp))
                OutlinedTextField(value = name.value ,
                    onValueChange = {name.value = it},
                    label= { Text(text = "Employee Name")},
                    modifier = Modifier
                        .fillMaxWidth())
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = id.value ,
                    onValueChange = {id.value = it},
                    label= { Text(text = "Employee ID")},
                    keyboardOptions = KeyboardOptions( keyboardType =  KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = dept.value ,
                    onValueChange = {dept.value = it},
                    label= { Text(text = "Dept")},
                    modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = { addEmp(name.value , id.value.toInt() , dept.value  ) }, modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
                {
                        Text("ADD EMPLOYEE")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { updateEmp(name.value, id.value.toInt(), dept.value) }, modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                    Text("UPDATE EMPLOYEE")
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { deleteEmp(id.value.toInt()) }, modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                    Text("DELETE EMPLOYEE")
                }
                println("result")
                var empList = remember {
                    mutableStateOf<List<User>>(emptyList())
                }
                fun displayEmployeeDetails(id: Int) {
                    fetchEmp(id) { emp ->
                        if (emp != null) {
                            Log.d(TAG, "Employee Name: ${emp.name}")
                            Log.d(TAG, "Employee ID: ${emp.id}")
                            Log.d(TAG, "Employee Dept: ${emp.dept}")
                            // Update UI elements here if necessary
                            // Example:
                            // textViewName.text = emp.name
                            // textViewID.text = emp.id.toString()
                            // textViewDept.text = emp.dept
                        } else {
                            Log.d(TAG, "Employee not found")
                            // Handle employee not found scenario
                            // Example:
                            // textViewName.text = "N/A"
                            // textViewID.text = "N/A"
                            // textViewDept.text = "N/A"
                        }
                    }
                }




            }

        }





}

data class Emp(
    val name: String ="",
    val id: Int = 0,
    val dept: String=""
)