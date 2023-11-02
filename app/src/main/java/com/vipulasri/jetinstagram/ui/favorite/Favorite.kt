package com.vipulasri.jetinstagram.ui.favorite

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.PostsRepository
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.Post
import com.vipulasri.jetinstagram.model.Story
import com.vipulasri.jetinstagram.ui.components.defaultPadding
import com.vipulasri.jetinstagram.ui.components.diagonalGradientBorder
import com.vipulasri.jetinstagram.ui.components.icon
import com.vipulasri.jetinstagram.ui.home.StoryImage


@ExperimentalFoundationApi
@Composable
fun Favorite() {


    val stories by StoriesRepository.observeStories()

    Scaffold(topBar = { Toolbar() }) {
        Column {

            TitleText()
            TextSearch()

            FavoriteUsers(stories = stories)
//            LazyColumn {
//                items(favoritePosts) { post ->
//                    FavoriteUsers()
//                }
        }

    }
}


@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.padding(6.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                ImageBitmap.imageResource(id = R.drawable.ic_cancel),
                contentDescription = ""
            )


        }
        Text(
            text = "Favorites", style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp, // You can adjust the font size as needed
                color = Color.Black
            )
        )

        Icon(
            ImageBitmap.imageResource(id = R.drawable.plus),
            modifier = Modifier.icon(),
            contentDescription = ""
        )
    }
}


@Composable
fun TitleText() {
    Box(
        modifier = Modifier.padding(6.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "New Posts From Your Favorites Will Appear Higher In Feed. Only you " +
                    "Can see Who You Add or Remove. How it works:",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp, // You can adjust the font size as needed
                color = Color.Black
            )
        )
    }
}

@Composable
fun TextSearch() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

        BasicTextField(
            value = "",
            onValueChange = { /* Handle value change here */ },
            textStyle = TextStyle.Default.copy(fontWeight = FontWeight.Normal),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    // Handle search action
                }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        )
    }

    Divider()
}

@Composable
fun FavoriteUsers(stories: List<Story>) {
    LazyColumn {
        items(stories) { story ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultPadding(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .diagonalGradientBorder(
                            colors = listOf(
                                Color(0xFFd71069),
                                Color(0xFFe25d6a),
                                Color(0xFFe9ad55),
                            ),
                            shape = CircleShape,
                            isFromRight = true
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .size(66.dp)
                            .padding(6.dp)
                            .background(color = Color.LightGray, shape = CircleShape)
                            .clip(CircleShape)
                    ) {
                        Image(
                            painter = rememberImagePainter(story.image),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                Column(
                    modifier = Modifier.weight(1f)
                        .padding(start =3.dp )
                ) {
                    Text(
                        text = "Fname Lname",
                        style = MaterialTheme.typography.subtitle2
                    )
                    Text(
                        text = story.name,
                        style = MaterialTheme.typography.subtitle2
                    )
                }

                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier
                        .size(120.dp, 40.dp) // Customize the size as needed
                        .border(1.dp, MaterialTheme.colors.background, shape = CircleShape)
                ) {
                    Text(
                        text = "Add",
                        style = MaterialTheme.typography.button
                    )
                }
            }
        }
    }
}



//@Composable
//fun FavoriteUsers(stories: List<Story>) {
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .defaultPadding(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        LazyColumn {
//            itemsIndexed(stories) { index, story ->
//                Row {
//                Box(
//                    modifier = Modifier
//                        .diagonalGradientBorder(
//                            colors = listOf(
//                                Color(0xFFd71069),
//                                Color(0xFFe25d6a),
//                                Color(0xFFe9ad55),
//                            ),
//                            shape = CircleShape,
//                            isFromRight = true
//                        )
//                ) {
//                    Box(
//                        modifier = Modifier
//                            .size(66.dp)
//                            .padding(6.dp)
//                            .background(color = Color.LightGray, shape = CircleShape)
//                            .clip(CircleShape)
//                    ) {
//                        Image(
//                            painter = rememberImagePainter(story.image),
//                            contentDescription = null,
//                            modifier = Modifier.fillMaxSize()
//                        )
//
//
//                        //Spacer(modifier = Modifier.width(10.dp))
//
//
//                    Column {
//
//
//
//                        Text(
//                            "text = post.user.username",
//                            style = MaterialTheme.typography.subtitle2
//                        )
//                        Text(text = story.name, style = MaterialTheme.typography.subtitle2)
//                    }}}
//
//        //Add Button
//        Button(
//            onClick = {},
//            modifier = Modifier
//                .size(120.dp, 40.dp)// Customize the size as needed
//                .border(1.dp, MaterialTheme.colors.background, shape = CircleShape)
//        ) {
//            Text(
//                text = "Add",
//                textAlign = TextAlign.Center,
////            modifier = Modifier
////                .padding(8.dp), // Adjust padding within the button as needed
//
//                style = MaterialTheme.typography.button.copy(
//                    color = Color.White // Set the text color to white
//                )
//            )}}}
//        }
//    }
//}



