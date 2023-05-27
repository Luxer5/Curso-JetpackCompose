package com.cartif.retotwitter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.cartif.retotwitter.ui.theme.RetoTwitterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetoTwitterTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF161D26))
                ) {
                    TwitterCard()
                    TwitDivider()
                }
            }
        }
    }
}

@Composable
fun TwitterCard() {
    var chat by remember { mutableStateOf(false) }
    var rt by remember { mutableStateOf(false) }
    var like by remember { mutableStateOf(false) }

    Row(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF161D26))
            .padding(16.dp)
    ) {
        Image(
            painterResource(id = R.drawable.profile),
            contentDescription = "IUmagen",
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .size(55.dp)
        )

        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                TextTitle("Aris", Modifier.padding(8.dp))
                DefText(title = "@AristiDevs", Modifier.padding(8.dp))
                DefText(title = "4h", Modifier.padding(8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_dots),
                    contentDescription = "dots",
                    tint = Color.White
                )
            }
            TextBody(
                "Estop es una frase larga jaja jaijiaj" +
                        "Estop es una frase larga jaja jaijiaj" +
                        "Estop es una frase larga jaja jaijiaj" +
                        "Estop es una frase larga jaja jaijiaj" +
                        "Estop es una frase larga jaja jaijiaj",
                Modifier.padding(bottom = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(10)),
                contentScale = ContentScale.Crop
            )
            Row(Modifier.padding(top = 16.dp)) {
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = { Icon(painter = painterResource(id = R.drawable.ic_chat), contentDescription = "", tint = Color(0xFF7E8B98) ) },
                    selectedIcon = { Icon(painter = painterResource(id = R.drawable.ic_chat_filled), contentDescription = "", tint = Color(0xFF7E8B98) ) },
                    isSelected = chat
                ) {
                    chat = !chat
                }
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = { Icon(painter = painterResource(id = R.drawable.ic_rt), contentDescription = "", tint = Color(0xFF7E8B98) ) },
                    selectedIcon = { Icon(painter = painterResource(id = R.drawable.ic_rt), contentDescription = "", tint = Color(0xFF00FF27) ) },
                    isSelected = rt
                ) {
                    rt = !rt
                }
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = { Icon(painter = painterResource(id = R.drawable.ic_like), contentDescription = "", tint = Color(0xFF7E8B98) ) },
                    selectedIcon = { Icon(painter = painterResource(id = R.drawable.ic_like_filled), contentDescription = "", tint = Color(0xFFFF0000) ) },
                    isSelected = like
                ) {
                    like = !like
                }
            }
        }


    }
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean, onItemSelected: () -> Unit
) {
    val defaultValue = 1
    Row(modifier = modifier.clickable { onItemSelected() }, verticalAlignment = Alignment.CenterVertically) {
        if(isSelected){
            selectedIcon()
        }else {
            unselectedIcon()
        }
        Text(text = if(isSelected) (defaultValue +1).toString() else defaultValue.toString(),
        color = Color(0xFF7E8B98),
        fontSize = 12.sp,
        modifier = Modifier.padding(start = 4.dp))
    }
}

@Composable
fun TextBody(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = Color.White,
        modifier = modifier
    )
}

@Composable
fun TextTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 18.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = modifier
    )
}

@Composable
fun DefText(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        color = Color.Gray,
        modifier = modifier
    )
}

@Composable
fun TwitDivider(){
    Divider(
        Modifier
            .padding(top = 4.dp)
            .height(0.5.dp)
            .fillMaxWidth(),
        color = Color(0xFF7E8B98)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RetoTwitterTheme {
        TwitterCard()
    }
}