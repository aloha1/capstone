package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Onboarding() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(start = 32.dp, end = 32.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Title",
            modifier = Modifier.fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .height(50.dp),
        )
        Text(
//            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally).height(100.dp),
            text = "Let's get to know you"
        )
        Text(
//            modifier = Modifier.fillMaxWidth(),
            text = "Personal information"
        )
        Text(
            text = "First name"
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "first name",
            onValueChange = {}
        )
        Text(
            text = "Last name"
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "last name",
            onValueChange = {}
        )
        Text(
            text = "Email"
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = "email",
            onValueChange = {}
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            content = {},
            onClick = {}
        )
    }
}

@Preview
@Composable
fun OnboardingPreview(){
    Onboarding()
}

