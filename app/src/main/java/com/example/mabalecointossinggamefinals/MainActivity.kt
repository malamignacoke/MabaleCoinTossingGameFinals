package com.example.mabalecointossinggamefinals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mabalecointossinggamefinals.ui.theme.MabaleCoinTossingGameFinalsTheme

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

}

@Composable
fun MainPlayScreen(modifier: Modifier = Modifier, navController: NavController){

}

@Composable
fun MainInstructionsScreen(modifier: Modifier = Modifier, navController: NavController){

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MabaleCoinTossingGameFinalsTheme {
        MainApp()
    }
}