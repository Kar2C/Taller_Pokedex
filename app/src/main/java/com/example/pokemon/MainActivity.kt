package com.example.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.example.pokemon.ui.theme.PokemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonTheme {
                PokedexApp()
            }
        }
    }
}

@Composable
fun PokedexApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { PokedexScreen(navController) }
        composable("region/{regionName}") { backStackEntry ->
            val regionName = backStackEntry.arguments?.getString("regionName")
            regionName?.let { ShowRegionPokemonScreen(regionName = it, navController = navController) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBar(navController) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {
                    navController.navigate("region/Kanto")
                }
            ) {
                Text("Ver Pokémon de Kanto")
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {
                    navController.navigate("region/Hoenn")
                }
            ) {
                Text("Ver Pokémon de Hoenn")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {
                    navController.navigate("region/Galar")
                }
            ) {
                Text("Ver Pokémon de Galar")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {
                    navController.navigate("region/Paldea")
                }
            ) {
                Text("Ver Pokémon de Paldea")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {
                    navController.navigate("region/Hisui")
                }
            ) {
                Text("Ver Pokémon de Hisui")
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {
                    navController.navigate("region/Alola")
                }
            ) {
                Text("Ver Pokémon de Alola")
            }
        }
    }
}

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.navigate("home") }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "Home",
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Pokedex",
            fontSize = 24.sp,
        )
    }
}
