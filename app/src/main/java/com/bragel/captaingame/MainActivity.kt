package com.bragel.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bragel.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    captainGame()
                }
            }
        }
    }

    @Composable
    fun captainGame() {
        val treasuresFound = remember { mutableStateOf(0) }
        val hp = remember { mutableStateOf(10) }
        val stormOrTreasure = remember { mutableStateOf("") }

        // using "by" instead of "=" will directly give the value to the variable no
        // longer need to use .value to get value when using variable
        var direction by remember { mutableStateOf("North") }

        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text("Current HP: ${hp.value}")
            Text(stormOrTreasure.value)
            Text("Treasures Found: ${treasuresFound.value}")
            Text("Current Direction: ${direction}")

            ButtonDefaults.buttonColors(Color.Magenta)

            Row(Modifier.padding(10.dp)) {
                Column(Modifier.padding(0.dp, 25.dp)) {
                    Button(onClick = {
                        direction = "East"
                        if(Random.nextBoolean()) {
                            treasuresFound.value += 1
                            stormOrTreasure.value = "Treasure found!"
                            hp.value += 1
                        } else {
                            stormOrTreasure.value = "Storm ahead..."
                            hp.value -= 1
                        }
                    }) {
                        Text("Sail East")
                    }
                }

                Column {
                    Button(onClick = {
                        direction = "North"
                        if (Random.nextBoolean()) {
                            treasuresFound.value += 1
                            stormOrTreasure.value = "Treasure found!"
                            hp.value += 1
                        } else {
                            stormOrTreasure.value = "Storm ahead..."
                            hp.value -= 1
                        }
                    }) {
                        Text("Sail North")
                    }

                    Button(onClick = {
                        direction = "South"
                        if(Random.nextBoolean()) {
                            treasuresFound.value += 1
                            stormOrTreasure.value = "Treasure found!"
                            hp.value += 1
                        } else {
                            stormOrTreasure.value = "Storm ahead..."
                            hp.value -= 1
                        }
                    }) {
                        Text("Sail South")
                    }

                    if (hp.value <= 0) {
                        stormOrTreasure.value = "GAME OVER!"
                    }
                }

                Column(Modifier.padding(0.dp, 25.dp)) {
                    Button(onClick = {
                        direction = "West"
                        if(Random.nextBoolean()) {
                            treasuresFound.value += 1
                            stormOrTreasure.value = "Treasure found!"
                            hp.value += 1
                        } else {
                            stormOrTreasure.value = "Storm ahead..."
                            hp.value -= 1
                        }
                    }) {
                        Text("Sail West")
                    }
                }
            }
        }

        if (hp.value <= 0) {
            stormOrTreasure.value = "GAME OVER!"
        }
    }
}

