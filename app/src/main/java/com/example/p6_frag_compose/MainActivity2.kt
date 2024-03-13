package com.example.p6_frag_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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

               layout(name)
            }
        }
    }
}

@Composable
fun layout(name: String){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Text(text = "NAME: $name", color = Color.White)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    P6fragcomposeTheme {
//        layout()
//    }
//}