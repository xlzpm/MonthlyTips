package com.example.monthlytips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.monthlytips.data.monthlyTips
import com.example.monthlytips.ui.theme.MonthlyTIpsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonthlyTIpsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MonthlyTipApp()
                }
            }
        }
    }
}

@Composable
fun MonthlyTipApp(){
    Scaffold(
        topBar = {
            TipTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it){
            items(monthlyTips){
                TipItem(
                    tip = it
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MonthlyTipAppPreview(){
    MonthlyTIpsTheme {
        MonthlyTipApp()
    }
}