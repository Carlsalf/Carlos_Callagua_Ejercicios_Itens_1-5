@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package es.ua.eps.filmoteca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class FilmDetailComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = intent.getStringExtra("title") ?: ""
        val year = intent.getIntExtra("year", 0)
        val synopsis = intent.getStringExtra("synopsis") ?: ""

        setContent {
            MaterialTheme {
                FilmDetailScreen(title, year, synopsis) { finish() }
            }
        }
    }
}

@Composable
fun FilmDetailScreen(
    title: String,
    year: Int,
    synopsis: String,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = { TextButton(onClick = onBack) { Text("Atrás") } }
            )
        }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            Text("Año: $year", style = MaterialTheme.typography.titleSmall)
            Spacer(Modifier.height(12.dp))
            Text(synopsis, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
