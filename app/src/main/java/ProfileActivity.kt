package com.example.profileapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    val context = LocalContext.current

    AndroidView(
        factory = { ctx ->
            val view = LayoutInflater.from(ctx).inflate(R.layout.activity_profile, null, false)

            // Set up click listeners
            view.findViewById<android.widget.ImageButton>(R.id.btnBack)?.setOnClickListener {
                if (context is AppCompatActivity) context.finish()
            }

            view.findViewById<androidx.cardview.widget.CardView>(R.id.supportCard)?.setOnClickListener {
                Toast.makeText(context, "Support clicked", Toast.LENGTH_SHORT).show()
            }

            view.findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fabEdit)?.setOnClickListener {
                Toast.makeText(context, "Edit profile clicked", Toast.LENGTH_SHORT).show()
            }

            view.findViewById<androidx.cardview.widget.CardView>(R.id.cardVehicle)?.setOnClickListener {
                Toast.makeText(context, "CRED garage clicked", Toast.LENGTH_SHORT).show()
            }

            view
        },
        modifier = Modifier.fillMaxSize()
    )
}