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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.myapplication.data.db.MenuItemRoom
import com.example.myapplication.ui.theme.LittleLemonColor
import java.util.Locale

@Composable
fun HomeScreen(
    menuItems: List<MenuItemRoom>,
    onClick: ()->Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        var orderedItems by remember { mutableStateOf("") }
        var searchPhrase by remember { mutableStateOf("") }
        Column {
            TopAppBar(onClick)
            UpperPanel(searchPhrase){ searchPhrase = it }
            WeeklySpecialCard{ orderedItems = it }
            MenuItemsList(
                menuItems
                .filter{ it.category.contains(orderedItems) }
                .filter{ it.title.lowercase(Locale.getDefault()).contains(searchPhrase) }
            )
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
fun UpperPanel(searchPhrase: String, onValueChanged: (String) -> Unit) {
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
        OutlinedTextField(
            value = searchPhrase,
            onValueChange = onValueChanged,
            placeholder = { Text(text = "Enter to Search", modifier = Modifier.background(Color.White)) },
            leadingIcon = { Icon( imageVector = Icons.Default.Search, contentDescription = "") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, top = 16.dp)
                .clip(shape = RoundedCornerShape(4.dp))
                .background(Color.White)
        )
    }
}

@Composable
fun WeeklySpecialCard(onClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "ORDER FOR DELIVERY!",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(8.dp)
            )
            Row(modifier = Modifier.height(45.dp)) {
                Button(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    onClick = { onClick("starter") }
                ) {
                    Text(text = "Starter")
                }
                Button(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    onClick = { onClick("mains") }
                ) {
                    Text(text = "Mains")
                }
                Button(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    onClick = { onClick("desserts") }

                ) {
                    Text(text = "Desert")
                }
                Button(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    onClick = { onClick("") }
                ) {
                    Text(text = "All")
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun MenuItemsList(items: List<MenuItemRoom>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        items(
            items = items,
            itemContent = { menuItem ->
                Divider(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    thickness = 1.dp,
                    color = LittleLemonColor.yellow
                )
                Card {
                    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                        Column {
                            Text(
                                text = menuItem.title,
                                style = MaterialTheme.typography.headlineSmall
                            )
                            Text(
                                text = menuItem.description,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier
                                    .fillMaxWidth(fraction = 0.75F)
                                    .padding(top = 5.dp, bottom = 5.dp)
                            )
                            Text(
                                text = "price: ${menuItem.price}g",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        GlideImage(
                            model = menuItem.image,
                            modifier = Modifier.fillMaxHeight(),
                            contentDescription = "Dish Image"
                        )
                    }
                }
            }
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
    UpperPanel("") {}
}

@Preview(showBackground = true)
@Composable
fun WeeklySpecialCardPreview() {
    WeeklySpecialCard{ }
}
