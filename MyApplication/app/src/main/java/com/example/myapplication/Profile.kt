package com.example.myapplication

import android.content.Context
import androidx.activity.ComponentActivity.MODE_PRIVATE
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun Profile(
    context: Context,
    navController: NavController,
    onClick: (navController: NavController)->Unit = {}
) {
    val sharedPreferences = context.getSharedPreferences("User", MODE_PRIVATE)
    val firstName = sharedPreferences.getString("first_name","")
    val lastName = sharedPreferences.getString("last_name","")
    val email = sharedPreferences.getString("email","")
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
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
                .padding(horizontal = 32.dp, vertical = 70.dp)
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
            value = firstName.orEmpty(),
            onValueChange = {}
        )
        Text(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
            text = "Last name"
        )
        TextField(
            modifier = Modifier.padding(horizontal = 32.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            value = lastName.orEmpty(),
            onValueChange = {}
        )
        Text(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp),
            text = "Email"
        )
        TextField(
            modifier = Modifier.padding(horizontal = 32.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            value = email.orEmpty(),
            onValueChange = {}
        )
        Button(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 32.dp)
                .fillMaxWidth(),
            onClick = { onClick(navController) }
        ){
            Text(
                text = "Log Out",
                textAlign = TextAlign.Center
            )
        }
    }
}
