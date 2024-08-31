package com.example.messenger.ui.chatList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.messenger.ui.common.UserInputTextField
import com.example.messenger.ui.theme.MessengerAppTheme

@Composable
fun ChatList(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { InputMessage() }
    ) {
        
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
   TopAppBar(
       colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
       ),
       title = {
           Text(
               text = "Chats",
               textAlign = TextAlign.Center,
               color = MaterialTheme.colorScheme.onPrimaryContainer,
               style = MaterialTheme.typography.headlineLarge
           )
       },
       navigationIcon = {
           Icon(
               imageVector = Icons.Default.Person,
               contentDescription = null,
               tint = MaterialTheme.colorScheme.secondary,
               modifier = Modifier
                   .size(48.dp)
           )
       },
       modifier = modifier
   )
}

@Composable
fun InputMessage(modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
        Box (
            modifier = Modifier
                .padding(top= 8.dp, bottom = 8.dp)
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            UserInputTextField()
            IconButton(
                onClick = { /*send*/ },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            ) {
                Icon(imageVector = Icons.Default.Send, contentDescription = null)
            }
        }
    }
}


@Preview
@Composable
private fun TopBarPreview() {
    MessengerAppTheme {
        TopBar()
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    MessengerAppTheme {
        ChatList()
    }
}