package com.example.messenger.ui.authorization

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.messenger.ui.common.CodeTextField
import com.example.messenger.ui.common.SampleButton
import com.example.messenger.ui.theme.MessengerAppTheme

@Composable
fun AuthorizationScreen() {
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    var selectedRegionCode by rememberSaveable { mutableStateOf("+7") }

    Surface(
        color = MaterialTheme.colorScheme.background,
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(32.dp)
                .wrapContentSize()
        ) {
            Text(
                text = "Введите номер телефона",
                style = MaterialTheme.typography.displaySmall
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                value = phoneNumber,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                leadingIcon = {
                    IconButton(
                        onClick = { expanded = !expanded }
                    ) {
                        Text(
                            text = selectedRegionCode,
                            style = MaterialTheme.typography.titleMedium,
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primaryContainer)
                            .width(48.dp)
                    ) {
                        listOf("+1", "+44", "+91", "+7").forEach { region ->
                            DropdownMenuItem(
                                text = { Text(text = region) },
                                onClick = {
                                    selectedRegionCode = region
                                    expanded = false
                                }
                            )
                        }
                    }
                },
                textStyle = MaterialTheme.typography.bodyLarge,
                onValueChange = {phoneNumber = it},
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            SampleButton(
                text = "Войти",
                click = { }
            )
        }
    }
}


@Composable
fun CheckAuthorizationScreen() {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(32.dp)
                .wrapContentSize()
        ) {
            Text(
                text = "Отправили код на +7 937 621 52 72",
                style = MaterialTheme.typography.displaySmall
            )

            Spacer(modifier = Modifier.height(32.dp))

            CodeTextField()
        }

    }
}

@Composable
fun RegistrationScreen(){

}

@Preview(name = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(name = "light")
@Composable
fun AuthorizationScreenPreview() {
    MessengerAppTheme {
        AuthorizationScreen()
    }
}

@Preview(name = "dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(name = "light")
@Composable
fun CheckAuthorizationScreenPreview() {
    MessengerAppTheme {
        CheckAuthorizationScreen()
    }
}