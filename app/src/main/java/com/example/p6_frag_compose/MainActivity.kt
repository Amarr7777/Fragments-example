package com.example.p6_frag_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p6_frag_compose.ui.theme.P6fragcomposeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            P6fragcomposeTheme {
                mainScreen()
            }
        }
    }
}

@Composable
fun mainScreen() {
    var showFormInputs by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize().background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.log),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
//            alpha = 0.2f // Adjust the alpha value to control the opacity of the image
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (showFormInputs) {
                formInputs()
            } else {
                formInputs2()
            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                if (showFormInputs) {
                    next(onNextClicked = { showFormInputs = false })
                } else {
                    back(onNextClicked = { showFormInputs = true })
                    next(onNextClicked = { showFormInputs = false })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formInputs() {
    Column {
        Text(text = "Name", color = Color.White)
        var name by remember { mutableStateOf("") }
        TextField(value = name, onValueChange = { name = it }, modifier = Modifier.padding(0.dp, 10.dp))
        Text(text = "Email", color = Color.White)
        var email by remember { mutableStateOf("") }
        TextField(value = email, onValueChange = { email = it }, modifier = Modifier.padding(0.dp, 10.dp))
        Text(text = "Phone", color = Color.White)
        var phone by remember { mutableStateOf("") }
        TextField(value = phone, onValueChange = { phone = it }, modifier = Modifier.padding(0.dp, 10.dp))


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formInputs2() {
    Column {
        Text(text = "Course", color = Color.White)
        var course by remember { mutableStateOf("") }
        TextField(value = course, onValueChange = { course = it }, modifier = Modifier.padding(0.dp, 10.dp))
        Text(text = "semester", color = Color.White)
        var semester by remember { mutableStateOf("") }
        TextField(value = semester, onValueChange = { semester = it }, modifier = Modifier.padding(0.dp, 10.dp))
    }
}

@Composable
fun next(onNextClicked: () -> Unit) {
    Button(onClick = onNextClicked) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "Next", modifier = Modifier.padding(10.dp,0.dp))
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "arrow", modifier = Modifier.size(18.dp) )
        }
    }
}
@Composable
fun back(onNextClicked: () -> Unit) {
    Button(onClick = onNextClicked) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "arrow", modifier = Modifier.size(18.dp) )
            Text(text = "Back", modifier = Modifier.padding(10.dp,0.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    P6fragcomposeTheme {
        mainScreen()
    }
}
