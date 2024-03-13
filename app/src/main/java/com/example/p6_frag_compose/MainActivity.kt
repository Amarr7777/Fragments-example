package com.example.p6_frag_compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p6_frag_compose.ui.theme.Mgreen
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
    var currentFormInput by remember { mutableStateOf(1) }
    var name by remember { mutableStateOf("") } // State to hold the name entered in formInputs
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var sex by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var semester by remember { mutableStateOf("") }
    var hobbies by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.log),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (currentFormInput) {
                1 -> formInputs(
                    onNameEntered = { newName -> name = newName },
                    onEmailEntered = { newEmail -> email = newEmail },
                    onPhoneEntered = { newPhone -> phone = newPhone })
                2 -> formInputs2(name = name, onAgeEntered = { newAge -> age = newAge }, onSexEntered = { newSex -> sex = newSex })
                3 -> formInputs3(onCourseEntered = { newCourse -> course = newCourse }, onSemesterEntered = { newSemester -> semester = newSemester })
                4 -> formInputs4(onHobbiesEntered = { newHobbies -> hobbies = newHobbies })
            }
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                if (currentFormInput == 1) {
                    next(onNextClicked = { currentFormInput = 2 })
                } else if (currentFormInput == 2) {
                    back(onNextClicked = { currentFormInput = 1 })
                    Spacer(modifier = Modifier.padding(10.dp,0.dp))
                    next(onNextClicked = { currentFormInput = 3 })
                } else if (currentFormInput == 3) {
                    back(onNextClicked = { currentFormInput = 2 })
                    Spacer(modifier = Modifier.padding(10.dp,0.dp))
                    next(onNextClicked = { currentFormInput = 4 })
                } else {
                    back(onNextClicked = { currentFormInput = 3 })
                    Spacer(modifier = Modifier.padding(10.dp,0.dp))
                    submit(
                        name = name,
                        email = email,
                        phone = phone,
                        age = age,
                        sex = sex,
                        course = course,
                        semester = semester,
                        hobbies = hobbies
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formInputs(onNameEntered: (String) -> Unit,
               onEmailEntered: (String) -> Unit,
               onPhoneEntered: (String) -> Unit) {
    Column {
        Text(text = "Name", color = Color.White)
        var name by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(width = 1.dp, color = Mgreen, shape = CircleShape) // Set the border color and width
        ){

        TextField(value = name, onValueChange = {
            name = it
            onNameEntered(it) // Invoke the lambda with the updated name
        }, modifier = Modifier.padding(0.dp),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Black, textColor = Color.White,focusedIndicatorColor = Color.Transparent, // Remove the focused indicator
                unfocusedIndicatorColor = Color.Transparent))
        }
        Text(text = "Email", color = Color.White)
        var email by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(width = 1.dp, color = Mgreen, shape = CircleShape) // Set the border color and width
        ){

        TextField(value = email, onValueChange = {
            email = it
            onEmailEntered(it)
           }, modifier = Modifier.padding(0.dp),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Black, textColor = Color.White,focusedIndicatorColor = Color.Transparent, // Remove the focused indicator
                unfocusedIndicatorColor = Color.Transparent))
        }
        Text(text = "Phone", color = Color.White)
        var phone by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(width = 1.dp, color = Mgreen, shape = CircleShape) // Set the border color and width
        ){

        TextField(value = phone, onValueChange = {
            phone = it
            onPhoneEntered(it)
            }, modifier = Modifier.padding(0.dp),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Black, textColor = Color.White,focusedIndicatorColor = Color.Transparent, // Remove the focused indicator
                unfocusedIndicatorColor = Color.Transparent))
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formInputs2(
    name: String,
    onAgeEntered: (String) -> Unit,
    onSexEntered: (String) -> Unit
) {
    Column {
        Text(
            text = "Hello, $name",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.padding(0.dp, 10.dp)
        ) // Displaying the name from formInputs
        Text(text = "Age", color = Color.White)
        var age by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(
                    width = 1.dp,
                    color = Mgreen,
                    shape = CircleShape
                ) // Set the border color and width
        ) {
            TextField(
                value = age,
                onValueChange = {
                    age = it
                    onAgeEntered(it)
                },
                modifier = Modifier.padding(0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Black,
                    textColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
        Text(text = "Sex", color = Color.White)
        var sex by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(
                    width = 1.dp,
                    color = Mgreen,
                    shape = CircleShape
                ) // Set the border color and width
        ) {
            TextField(
                value = sex,
                onValueChange = {
                    sex = it
                    onSexEntered(it)
                },
                modifier = Modifier.padding(0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Black,
                    textColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formInputs3(
    onCourseEntered: (String) -> Unit,
    onSemesterEntered: (String) -> Unit
) {
    Column {
        Text(text = "Course", color = Color.White)
        var course by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(
                    width = 1.dp,
                    color = Mgreen,
                    shape = CircleShape
                ) // Set the border color and width
        ) {
            TextField(
                value = course,
                onValueChange = {
                    course = it
                    onCourseEntered(it)
                },
                modifier = Modifier.padding(0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Black,
                    textColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
        Text(text = "Semester", color = Color.White)
        var semester by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(
                    width = 1.dp,
                    color = Mgreen,
                    shape = CircleShape
                ) // Set the border color and width
        ) {
            TextField(
                value = semester,
                onValueChange = {
                    semester = it
                    onSemesterEntered(it)
                },
                modifier = Modifier.padding(0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Black,
                    textColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formInputs4(onHobbiesEntered: (String) -> Unit) {
    Column {
        Text(text = "Hobbies", color = Color.White)
        var hobbies by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .padding(5.dp, 10.dp)
                .background(Color.Black)
                .border(
                    width = 1.dp,
                    color = Mgreen,
                    shape = CircleShape
                ) // Set the border color and width
        ) {
            TextField(
                value = hobbies,
                onValueChange = {
                    hobbies = it
                    onHobbiesEntered(it)
                },
                modifier = Modifier.padding(0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Black,
                    textColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
fun next(onNextClicked: () -> Unit) {
    Button(
        onClick = onNextClicked,
        colors = ButtonDefaults.buttonColors(Mgreen)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Next", color = Color.Black, modifier = Modifier.padding(10.dp, 0.dp))
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "arrow",
                modifier = Modifier.size(18.dp),
                tint = Color.Black
            )
        }
    }
}

@Composable
fun back(onNextClicked: () -> Unit) {
    Button(
        onClick = onNextClicked,
        colors = ButtonDefaults.buttonColors(Mgreen)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "arrow",
                modifier = Modifier.size(18.dp),
                tint = Color.Black
            )
            Text(text = "Back", color = Color.Black, modifier = Modifier.padding(10.dp, 0.dp))
        }
    }
}

@Composable
fun submit(
    name: String,
    email: String,
    phone: String,
    age: String,
    sex: String,
    course: String,
    semester: String,
    hobbies: String
) {
    val context = LocalContext.current
    val intent = remember {
        Intent(context, MainActivity2::class.java).apply {
            putExtra("NAME", name)
            putExtra("EMAIL", email)
            putExtra("PHONE", phone)
            putExtra("AGE", age)
            putExtra("SEX", sex)
            putExtra("COURSE", course)
            putExtra("SEMESTER", semester)
            putExtra("HOBBIES", hobbies)
        }
    }
    Button(
        onClick = { context.startActivity(intent) },
        colors = ButtonDefaults.buttonColors(Mgreen)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = "Submit", color = Color.Black, modifier = Modifier.padding(10.dp, 0.dp))
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "arrow",
                modifier = Modifier.size(18.dp),
                tint = Color.Black
            )
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
