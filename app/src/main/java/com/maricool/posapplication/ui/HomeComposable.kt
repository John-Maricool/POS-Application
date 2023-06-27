package com.maricool.posapplication.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.maricool.posapplication.R
import com.maricool.posapplication.ui.theme.typography
import com.maricool.posapplication.utils.Routes

@Composable
fun HomeComposable(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xE8EEF1EF).copy(alpha = 0.4f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeTopHeader()
        Spacer(modifier = Modifier.height(10.dp))
        AccountBalanceComposable()
        Spacer(modifier = Modifier.height(12.dp))
        SetTransactionPinComposable{
            navController.navigate(Routes.setup_pin)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Quick Actions",
            style = typography.bodyMedium,
            fontWeight = FontWeight.Bold, fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .absolutePadding(left = 15.dp)
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        QuickActionsComposables()
    }
}

@Composable
fun QuickActionsComposables() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .background(Color.White)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SingleQuickActionComposable(
                title = "Buy Airtime",
                detail = "Top up airtime for your customers",
                icon = R.drawable.baseline_data_exploration_24
            )
            Divider(color = Color(0xE8EEF1EF))
            SingleQuickActionComposable(
                title = "Buy Data",
                detail = "Get your Data Subscriptions here",
                icon = R.drawable.baseline_perm_data_setting_24
            )
            Divider(color = Color(0xE8EEF1EF))
            SingleQuickActionComposable(
                title = "Pay Bills",
                detail = "Choose from list of payable options",
                icon = R.drawable.baseline_payment_24
            )
        }
    }
}

@Composable
fun SingleQuickActionComposable(title: String, detail: String, icon: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color.LightGray.copy(alpha = 0.3f))
        ) {
            Icon(
                painter = painterResource(id = icon),
                tint = Color(0xFF02EC3D),
                contentDescription = "Info ",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(20.dp)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = title,
                style = typography.bodyMedium,
                fontWeight = FontWeight.Bold, fontSize = 15.sp
            )
            Text(
                text = detail,
                style = typography.bodySmall,
                fontWeight = FontWeight.SemiBold, fontSize = 12.sp
            )
        }
    }
}

@Composable
fun SetTransactionPinComposable(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .background(Color.White)
            .clip(RoundedCornerShape(20.dp)).clickable {
                onClick()
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(Color.LightGray.copy(alpha = 0.3f))
            ) {
                Icon(
                    Icons.Rounded.Info,
                    tint = Color.LightGray,
                    contentDescription = "Info ",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(30.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Set Transaction Pin",
                    style = typography.bodyMedium,
                    fontWeight = FontWeight.Bold, fontSize = 15.sp
                )
                Text(
                    text = "Next step to setup your account",
                    style = typography.bodySmall,
                    fontWeight = FontWeight.SemiBold, fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun HomeTopHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text("Hi John", style = typography.bodySmall, fontWeight = FontWeight.Bold)
            RequestPOSButton {

            }
        }
    }
}

@Composable
fun RequestPOSButton(
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = Color.White
        ),
        modifier = Modifier
            .height(35.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                modifier = Modifier.padding(end = 2.dp),
                tint = MaterialTheme.colorScheme.surface
            )
            Text(
                "Request POS",
                style = typography.bodySmall,
                color = MaterialTheme.colorScheme.surface,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun AccountBalanceComposable() {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.9f))
            .clip(RoundedCornerShape(20.dp))

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)

        ) {
            Text(
                "Account Balance",
                style = typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "N0.00",
                style = typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row() {
                HomeOptions(onClick = {}, icon = Icons.Rounded.AddCircle, text = "Add Money")
                Spacer(modifier = Modifier.width(8.dp))
                HomeOptions(onClick = { /*TODO*/ }, icon = Icons.Filled.Send, text = "Send Money")

            }

        }
    }
}

@Composable
fun HomeOptions(
    onClick: () -> Unit, icon: ImageVector, text: String,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier
            .height(35.dp), border = BorderStroke(1.dp, MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Add",
                modifier = Modifier.padding(end = 2.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
            Text(
                " $text",
                style = typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
