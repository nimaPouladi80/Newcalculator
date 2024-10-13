package com.findingtheproblem

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.newcalculator.R
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


import androidx.appcompat.widget.AppCompatButton

 class MainActivity : ComponentActivity() {
     private val input= mutableListOf<String>()
     private val display=findViewById<TextView>(R.id.display)
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
    }
     fun onClick(button:View){
         input.add((button as AppCompatButton).text.toString())
         display.text="${display.text} ${button.text} "

     }



}
