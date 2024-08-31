package com.example.messenger.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.messenger.ui.theme.MessengerAppTheme

@Composable
fun CodeTextField(modifier: Modifier = Modifier) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        repeat(6){
            CodeItem(manager = LocalFocusManager.current)
        }
    }
}

@Composable
fun CodeItem(
    modifier: Modifier = Modifier,
    manager: FocusManager
) {
    var text by remember { mutableStateOf("") }


    OutlinedTextField(
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        value = text,
        placeholder = { Text(text = "*")},
        shape = MaterialTheme.shapes.medium,
        onValueChange = { newText ->
            if(newText.length <= 1) text = newText

            if (newText.length == 1) manager.moveFocus(FocusDirection.Right)

        },
        singleLine = true,
        modifier = modifier
            .width(48.dp),
        textStyle =  MaterialTheme.typography.headlineSmall,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        )
    )
}

@Composable
fun BoxScope.UserInputTextField(
    modifier: Modifier = Modifier
){
    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        textStyle = MaterialTheme.typography.titleMedium,
        onValueChange = {newText ->
            text = newText
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Send
        ),
        modifier = modifier
            .padding(start = 16.dp, end = 8.dp)
            .align(Alignment.CenterStart)
    )
}

@Preview
@Composable
fun Preview(){
    MessengerAppTheme {

    }
}