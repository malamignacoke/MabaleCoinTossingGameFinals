package com.example.mabalecointossinggamefinals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import com.example.mabalecointossinggamefinals.ui.theme.MabaleCoinTossingGameFinalsTheme

public val Icons.Filled.ExpandMore: ImageVector
    get() {
        if (_expandMore != null) {
            return _expandMore!!
        }
        _expandMore = materialIcon(name = "Filled.ExpandMore") {
            materialPath {
                moveTo(16.59f, 8.59f)
                lineTo(12.0f, 13.17f)
                lineTo(7.41f, 8.59f)
                lineTo(6.0f, 10.0f)
                lineToRelative(6.0f, 6.0f)
                lineToRelative(6.0f, -6.0f)
                close()
            }
        }
        return _expandMore!!
    }

private var _expandMore: ImageVector? = null

public val Icons.Filled.ExpandLess: ImageVector
    get() {
        if (_expandLess != null) {
            return _expandLess!!
        }
        _expandLess = materialIcon(name = "Filled.ExpandLess") {
            materialPath {
                moveTo(12.0f, 8.0f)
                lineToRelative(-6.0f, 6.0f)
                lineToRelative(1.41f, 1.41f)
                lineTo(12.0f, 10.83f)
                lineToRelative(4.59f, 4.58f)
                lineTo(18.0f, 14.0f)
                close()
            }
        }
        return _expandLess!!
    }

private var _expandLess: ImageVector? = null


//Para sa screen navigation, idea from Act#8
enum class CTScreen{
    DefaultScreen,
    PlayScreen,
    InstructionsScreen
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MabaleCoinTossingGameFinalsTheme {
                MainApp()
            }
        }
    }
}

@Composable //ito yung pinaka structure ng code gamit ang column and rows
fun MainApp(){
    Column {
        Row (
            modifier = Modifier
                .background(Color(0xFF0B0C10))
                .height(15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            //black top
        }
        Row (
            modifier = Modifier
                .background(Color(0xFF202833))
                .fillMaxWidth()
                .fillMaxHeight(.983f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            AlternatingScreen()
        }
        Row (
            modifier = Modifier
                .background(Color(0xFF0B0C10))
                .height(15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            //black bottom
        }
    }
}

@Composable //dito nangyayari yung pag-navigate ng screen by the use of buttons
fun AlternatingScreen(navController: NavHostController = rememberNavController()){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CTScreen.valueOf(
        backStackEntry?.destination?.route ?: "DefaultScreen"
    )
    NavHost(
        navController = navController,
        startDestination = "DefaultScreen"
    ) {
        composable("DefaultScreen"){ MainDefaultScreen(navController = navController) }
        composable("PlayScreen"){ MainPlayScreen(navController = navController) }
        composable("InstructionsScreen"){ MainInstructionsScreen(navController = navController) }
    }
}

@Composable
fun MainDefaultScreen(modifier: Modifier = Modifier, navController: NavController){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row{
            Text(
                text = "MABALE's",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF66FCF1)
            )
        }
        Row{
            Text(
                text = "COIN TOSSING",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF66FCF1)
            )
        }
        Row{
            Text(
                text = "GAME",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF66FCF1)
            )
        }
        Spacer(
            //margin para sa buttons
            modifier = Modifier
                .height(16.dp)
        )
        Row {
            //PlayBtn
            Button(
                onClick = { navController.navigate("PlayScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF202833),
                    contentColor = Color(0xFFC5C6C8),
                ),
                modifier = Modifier
                    .border(2.dp, Color(0xFF46A29F))
                    .height(50.dp)
            )  {
                Text(
                    stringResource(R.string.play_btn),
                    fontSize = 15.sp
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Row {
            //InstructionsBtn
            Button(
                onClick = { navController.navigate("InstructionsScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF202833),
                    contentColor = Color(0xFFC5C6C8),
                ),
                modifier = Modifier
                    .border(2.dp, Color(0xFF46A29F))
                    .height(50.dp)
                    .fillMaxWidth(.4f)
            )  {
                Text(
                    stringResource(R.string.instructions_btn),
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Composable
fun MainPlayScreen(modifier: Modifier = Modifier, navController: NavController){
    Text(
        text = "HAHA meow?",
        fontSize = 15.sp
    )
}

@Composable
fun MainInstructionsScreen(modifier: Modifier = Modifier, navController: NavController){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            // text
            Text(
                text = "INSTRUCTIONS:",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF66FCF1)
            )
        }
        Spacer(
            modifier = Modifier
                .height(8.5.dp)
        )
        Row {
            //Dropdown 1
            Item(
                titledesc = stringResource(R.string.checkans_title),
                descinfo = stringResource(R.string.checkans_desc)
            )
        }
        Spacer(
            modifier = Modifier
                .height(8.5.dp)
        )
        Row {
            //Dropdown 2
            Item(
                titledesc = stringResource(R.string.playgame_title),
                descinfo = stringResource(R.string.playgame_desc)
            )
        }
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Row {
            //BackBtn
            Button(
                onClick = { navController.navigate("DefaultScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF202833),
                    contentColor = Color(0xFFC5C6C8),
                ),
                modifier = Modifier
                    .border(2.dp, Color(0xFF46A29F))
                    .height(50.dp)
                    .fillMaxWidth(.3f)
            )  {
                Text(
                    stringResource(R.string.back_btn),
                    fontSize = 15.sp
                )
            }
        }
    }
}

//Dropdown

@Composable
fun Item(
    titledesc: String,
    descinfo:  String,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .border(2.dp, Color(0xFF46A29F))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = Color(0xFF202833))
        ) {
            Spacer(
                modifier = Modifier
                    .height(8.5.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .padding(5.dp)
                    .height(30.dp)
            ) {
                Spacer(Modifier.weight(1.5f))
                Text(
                    text = titledesc,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC5C6C8),
                    modifier = Modifier
                        .background(color = Color(0xFF202833))
                )
                Spacer(Modifier.weight(1f))
                ItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
            if (expanded) {
                LazyColumn(modifier = Modifier.fillMaxSize(.8f)) {
                    item {
                        //Description about the game.
                        Text(
                            text = descinfo,
                            fontSize = 15.sp,
                            textAlign = TextAlign.Justify,
                            color = Color(0xFFC5C6C8),
                            modifier = Modifier
                                .wrapContentSize(Alignment.TopCenter)
                                .padding(start = 20.dp, end = 20.dp, top = 15.dp)
                                .background(color = Color(0xFF202833))
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ItemButton(expanded: Boolean,onClick: () -> Unit,modifier: Modifier = Modifier) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_desc),
            tint = Color(0xFF66FCF1)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GamePreview() {
    MabaleCoinTossingGameFinalsTheme {
        MainApp()
    }
}