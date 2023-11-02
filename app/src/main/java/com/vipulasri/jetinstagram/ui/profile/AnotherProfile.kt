package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.ui.components.diagonalGradientBorder

@Composable
fun InstagramProfile() {
    val profileImageRes = R.drawable.ic_launcher_foreground
    val username = "your_username"
    val bio = "This is my bio. Welcome to my profile!"
    val posts = 1
    val followers = 1000
    val following = 500

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Profile") },
                backgroundColor = Color.DarkGray,
                elevation = 0.dp,
                actions = {
                    // Add action buttons here
                }
            )
        },
        content = {
            Column {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .diagonalGradientBorder(
                                colors = listOf(
                                    Color(0xFFd71069),
                                    Color(0xFFe25d6a),
                                    Color(0xFFe9ad55)
                                ),
                                shape = CircleShape,
                                isFromRight = true
                            )
                    ) {

                        Box(
                            modifier = Modifier
                                .size(77.dp)
                                .padding(6.dp)
                                .background(color = Color.LightGray, shape = CircleShape)
                                .clip(CircleShape)
                        ) {
                            Image(
                                painter = painterResource(id = profileImageRes),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }


                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row {
                                Text(text = "$posts")
                            }
                            Row {
                                Text(text = "Post")
                            }
                        }

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row {
                                Text(text = "$followers")
                            }
                            Row {
                                Text(text = "Followers")
                            }
                        }

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Row {
                                Text(text = "$following")
                            }
                            Row {
                                Text(text = "Following")
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "@sleek")
                    Text(text = "Personal Blog")
                    Text(text = "add something here")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { /* Handle button click */ },
                        modifier = Modifier
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Black,
                            //contentColor = Color.Black
                        ),
                        border = BorderStroke(1.dp, Color.Gray)
                    ) {
                        Text("Edit Profile",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                        color = Color.White
                        ))
                    }
                    Spacer(modifier = Modifier.width(8.dp));
                    Button(
                        onClick = { /* Handle button click */ },
                        modifier = Modifier
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Black,
                            //contentColor = Color.Black
                        ),
                        border = BorderStroke(1.dp, Color.Gray)
                    ) {
                        Text("Promotions",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            ))
                    }

                    Spacer(modifier = Modifier.width(8.dp));
                    Button(
                        onClick = { /* Handle button click */ },
                        modifier = Modifier
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Black,
                            //contentColor = Color.Black
                        ),
                        border = BorderStroke(2.dp, Color.Gray)
                    ) {
                        Text("Email",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            ))
                    }
                }

                var isCollapsed by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .clickable { isCollapsed = !isCollapsed } ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    //verticalArrangement = Arrangement.

                ) {
                    Text(
                        text = "Story Highlights",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                    if (!isCollapsed) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Keep your favorite stories on your profile",
                            style = TextStyle(color = Color.Black)
                        )
                    }


                }
                Box(
                    modifier = Modifier
                        .size(77.dp)
                        .padding(6.dp)
                        .background(color = Color.Black, shape = CircleShape)
                        .clip(CircleShape)
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                        horizontalAlignment = Alignment.Start
                    ) {



                        Image(
                            painter = painterResource(id = profileImageRes),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                }}
            }
        }
    )
}

