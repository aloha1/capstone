package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Onboarding(
    navController: NavController,
    onClick: (firstName: String, lastName: String, email: String, navController: NavController)->Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        var firstName by remember { mutableStateOf("") }
        var lastName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Title",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(100.dp)
                .width(240.dp),
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(125.dp)
                .background(color = Color.DarkGray)
                .padding(vertical = 12.dp),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Yellow,
            text = "Let's get to know you"
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 55.dp)
                .wrapContentHeight(),
            text = "Personal information"
        )
        Text(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
            text = "First name"
        )
        TextField(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            value = firstName,
            onValueChange = {
                firstName = it
            }
        )
        Text(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
            text = "Last name"
        )
        TextField(
            modifier = Modifier.padding(horizontal = 32.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            value = lastName,
            onValueChange = {
                lastName = it
            }
        )
        Text(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
            text = "Email"
        )
        TextField(
            modifier = Modifier.padding(horizontal = 32.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            value = email,
            onValueChange = {
                email = it
            }
        )
        Button(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 16.dp)
                .fillMaxWidth(),
            onClick = { onClick(firstName, lastName, email, navController) }
        ){
            Text(
                text = "Register",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun HomeScreen(
    onClick: ()->Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .height(75.dp),
            text = "Home Screen"
        )
        Button(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth(),
            onClick = onClick
        ){
            Text(
                text = "Go To Profile",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Profile(
    onClick: ()->Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .height(75.dp),
            text = "Profile"
        )
        Button(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth(),
            onClick = onClick
        ){
            Text(
                text = "Log Out",
                textAlign = TextAlign.Center
            )
        }
    }
}

//@Preview
//@Composable
//fun OnboardingPreview(){
//    Onboarding()
//}

