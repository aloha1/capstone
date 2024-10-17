package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.data.db.MenuItemRoom
import com.example.myapplication.ui.theme.LittleLemonColor
//import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    menuItems: List<MenuItemRoom>,
    onClick: ()->Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Column {
            TopAppBar(onClick)
            UpperPanel()
//            LowerPanel()
            MenuItemsList(menuItems)
        }

    }
}


@Composable
fun TopAppBar(onClick: ()->Unit) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier.fillMaxWidth(0.8F)
                .height(45.dp)
                .padding(horizontal = 20.dp)
        )
        IconButton(onClick = onClick) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Cart",
                modifier = Modifier.size(35.dp).padding(4.dp)
            )
        }
    }
}

@Composable
fun UpperPanel() {
    Column(
        modifier = Modifier
            .background(color = LittleLemonColor.green)
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = "Little Lemon",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = LittleLemonColor.yellow
        )
        Text(
            text = "Chicago",
            fontSize = 24.sp,
            color = LittleLemonColor.cloud
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(top = 20.dp)
        ) {
            Text(
                text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(bottom = 28.dp, end = 20.dp)
                    .fillMaxWidth(0.6f),
                color = LittleLemonColor.cloud
            )
            Image(
                painter = painterResource(id = R.drawable.hero_image),
                contentDescription = "Upper Panel Image",
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
        }
        Button(
            onClick = { }
        ) {
            Text(
                text = "Order Take Away"
            )
        }
    }
}


@Composable
private fun MenuItemsList(items: List<MenuItemRoom>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 20.dp)
    ) {
        items(
            items = items,
            itemContent = { menuItem ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(menuItem.title)
                    Text(menuItem.category)
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(5.dp),
                        textAlign = TextAlign.Right,
                        text = menuItem.price
                    )
                    Text(menuItem.description)

                }
            }
        )
    }
}

@Composable
fun LowerPanel(onClick: ()->Unit){
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

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun UpperPanelPreview() {
    UpperPanel()
}
