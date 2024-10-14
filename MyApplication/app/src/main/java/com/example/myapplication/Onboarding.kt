package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Onboarding() {
    Column(
        modifier = Modifier.fillMaxWidth(),
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
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
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
                .padding(horizontal = 32.dp)
                .height(75.dp),
            text = "Personal information"
        )
        Text(
            modifier = Modifier.padding(horizontal = 32.dp),
            text = "First name"
        )
        TextField(
            modifier = Modifier.padding(horizontal = 32.dp).fillMaxWidth(),
            value = "first name",
            onValueChange = {}
        )
        Text(
            modifier = Modifier.padding(horizontal = 32.dp),
            text = "Last name"
        )
        TextField(
            modifier = Modifier.padding(horizontal = 32.dp).fillMaxWidth(),
            value = "last name",
            onValueChange = {}
        )
        Text(
            modifier = Modifier.padding(horizontal = 32.dp),
            text = "Email"
        )
        TextField(
            modifier = Modifier.padding(horizontal = 32.dp).fillMaxWidth(),
            value = "email",
            onValueChange = {}
        )
        Button(
            modifier = Modifier.padding(horizontal = 32.dp),
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

