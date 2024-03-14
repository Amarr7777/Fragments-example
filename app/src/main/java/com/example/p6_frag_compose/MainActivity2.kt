package com.example.p6_frag_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p6_frag_compose.ui.theme.Mgreen
import com.example.p6_frag_compose.ui.theme.P6fragcomposeTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            P6fragcomposeTheme {
                val name = intent.getStringExtra("NAME") ?: ""
                val email = intent.getStringExtra("EMAIL") ?: ""
                val phone = intent.getStringExtra("PHONE") ?: ""
                val course = intent.getStringExtra("COURSE") ?: ""
                val semester = intent.getStringExtra("SEMESTER") ?: ""
                val hobbies = intent.getStringExtra("HOBBIES") ?: ""
                val age = intent.getStringExtra("AGE") ?: ""
                val sex = intent.getStringExtra("SEX") ?: ""

                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)) {
                    Spacer(modifier = Modifier.padding(0.dp, 50.dp))
                    layout(name = name, email = email)
                    Spacer(modifier = Modifier.padding(0.dp, 10.dp))
                    personal(phone = phone, age = age , sex = sex)
                    Spacer(modifier = Modifier.padding(0.dp, 10.dp))
                    coursep(course = course, semester = semester )
                }
            }
        }
    }
}
@Composable
fun layout(name: String, email: String) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp, horizontal = 16.dp)
    ) {
        Text(
            text = "Welcome, $name",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Email: $email",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

@Composable
fun personal(phone: String, age: String, sex: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Personal Details",
            fontSize = 20.sp,
            color = Mgreen
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Phone: $phone", color = Color.White)
        Text(text = "Age: $age", color = Color.White)
        Text(text = "Sex: $sex", color = Color.White)
    }
}

@Composable
fun coursep(course: String, semester: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Course Details",
            fontSize = 20.sp,
            color = Mgreen
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Course: $course", color = Color.White)
        Text(text = "Semester: $semester", color = Color.White)
    }
}


