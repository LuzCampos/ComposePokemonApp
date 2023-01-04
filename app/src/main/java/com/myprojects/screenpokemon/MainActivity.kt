package com.myprojects.screenpokemon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myprojects.screenpokemon.ui.theme.ScreenPokemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenPokemonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 30.dp),
                    color = MaterialTheme.colors.background
                ) {
                    Pokedex()
                }
            }
        }
    }
}

var bulbasaur:Pokemon = Pokemon("Bulbasaur","Poison", Color(0xff48D0B0), Color(0xFF5DDFC6),R.drawable.bulbasaur )
var ivysaur:Pokemon = Pokemon("Ivisaur","Poison",  Color(0xff46D0A7), Color(0xFF5DDFC6),R.drawable.ivysaur)
var charmander:Pokemon = Pokemon("Venasaur","Grass",  Color(0xff46D0A7), Color(0xFF5DDFC6),R.drawable.venusaurr)
var venusaur:Pokemon = Pokemon("Charmander","Fire",  Color(0xffFB6C6C), Color(0xFFFD8585),R.drawable.charmander )
var charmeleon:Pokemon = Pokemon("Charmaleon","Fire", Color(0xffFB6C6C), Color(0xFFFD8585),R.drawable.charneleon)
var charizard:Pokemon = Pokemon("Charizard","Flying",   Color(0xffFB6C6C), Color(0xFFFD8585), R.drawable.charizard)
var squirtle:Pokemon = Pokemon("Squirtle","Water",   Color(0xff7AC7FF), Color(0xFF8FD1FE), R.drawable.squirtle)
var wartorle:Pokemon = Pokemon("Wartortle","Water",   Color(0xff76BDFE), Color(0xFF8FD1FE),R.drawable.wartortle)
var blastoise:Pokemon = Pokemon("Blastoise","Water",   Color(0xff76BDFE), Color(0xFF8FD1FE), R.drawable.blastoise)
    var pikachu:Pokemon = Pokemon("Pikachu","Electric",   Color(0xffFFDB6F), Color(0xFFFFE58D), R.drawable.pikapika)

val pokemones: List<Pokemon> = listOf(bulbasaur, ivysaur, charmander, venusaur, charmeleon, charizard, squirtle, wartorle, blastoise, pikachu)


@Composable
fun Container(){
    LazyColumn() {
        item { 
            Box() {

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pokedex(){
    LazyVerticalGrid(cells = GridCells.Fixed(2)){
        items(pokemones.size){
            //Text(text = "${pokemones[it].hability}")
            PokemonCard(color = pokemones[it].colorCard, fondoText = pokemones[it].fondoTexto, name = pokemones[it].name, hability = pokemones[it].hability, pokemones[it].img )
        }
    }
}

@Composable
fun PokemonCard(color: Color, fondoText: Color, name: String, hability: String, imgCard: Int){
    Card(
        modifier = Modifier
            .height(130.dp)
            .padding(vertical = 5.dp, horizontal = 5.dp),
        backgroundColor = color,

        shape = RoundedCornerShape(20.dp))
    {
        Box(modifier = Modifier.padding(horizontal = 5.dp)) {
            Column(modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)) {
                Text(text = "$name",
                    color = Color.White,
                    fontSize = 16.sp,)
                Box(modifier = Modifier.height(9.dp))
                textoHabilidades(hability = hability, fondoText = fondoText)
                Box(modifier = Modifier.height(6.dp))
                textoHabilidades(hability = hability, fondoText = fondoText)
            }
            ImagenCardPokemon(modifier = Modifier.align(Alignment.BottomEnd).size(80.dp), imgCard)
        }
    }
}

@Composable
fun ImagenCardPokemon(modifier: Modifier, imgCard: Int){
    Image(painter = painterResource(id = imgCard),
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}

@Composable
fun textoHabilidades(hability: String, fondoText: Color){
    Text(text = "$hability",
        color = Color.White,
        fontSize = 8.sp,
        modifier = Modifier
            .drawBehind {
                drawRoundRect(
                    fondoText,
                    cornerRadius = CornerRadius(15.dp.toPx())
                )
            }
            .padding(horizontal = 15.dp)
            .padding(vertical = 3.dp))
}