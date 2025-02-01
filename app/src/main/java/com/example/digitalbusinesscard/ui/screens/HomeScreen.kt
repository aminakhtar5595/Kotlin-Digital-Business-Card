package com.example.digitalbusinesscard.ui.screens
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.digitalbusinesscard.ui.viewmodels.BusinessCardViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: BusinessCardViewModel) {
    val fullName = viewModel.fullName.ifBlank { "Elon Musk" }
    val jobTitle = viewModel.jobTitle.ifBlank { "Founder" }
    val company = viewModel.company.ifBlank { "Tesla" }
    val phoneNumber = viewModel.phoneNumber.ifBlank { "03331234567" }
    val email = viewModel.email.ifBlank { "elon@tesla.com" }

    Column (
        modifier = Modifier
            .padding(vertical = 20.dp)
    ) {
        Text(
            text = "Home",
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
            ,
            textAlign = TextAlign.Center
        )
        Divider(color = Color.Black, thickness = 0.5.dp,
            modifier = Modifier
                .padding(bottom = 30.dp)
            )

        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            border = BorderStroke(1.dp, Color.Black),
        ) {
            Column (
                modifier = Modifier
                    .padding(15.dp)
            ) {
                Text(
                    text = fullName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )

                Text(
                    text = jobTitle,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )

                Text(
                    text = company,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )

                Row {
                    Icon(
                        imageVector = Icons.Filled.Phone,
                        contentDescription = "Phone",
                        modifier = Modifier
                            .size(18.dp)
                    )

                    Text(
                        text = phoneNumber,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier
                            .padding(start = 10.dp, bottom = 10.dp)
                    )
                }

                Row {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email Icon",
                        modifier = Modifier
                            .size(18.dp)
                    )

                    Text(
                        text = email,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier
                            .padding(start = 10.dp)
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { navController.navigate("editCardScreen") },
                ) {
                Text(text = "Create Card")
            }

            Button(onClick = {  },
            ) {
                Text(text = "Share Card")
            }
        }
    }
}