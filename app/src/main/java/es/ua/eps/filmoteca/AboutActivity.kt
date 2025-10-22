package es.ua.eps.filmoteca

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button as M3Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

// Conmutador de modo
enum class Mode { Layouts, Compose }

class AboutActivity : AppCompatActivity() {

    // Cambia aquí para tus capturas
    private val mode = Mode.Compose   // o Mode.Layouts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    private fun initUI() {
        when (mode) {
            Mode.Layouts -> initLayouts()
            Mode.Compose -> initCompose()
        }
    }

    // ===== MODO XML =====
    private fun initLayouts() {
        setContentView(R.layout.activity_about)

        val msg = getString(R.string.toast_pendiente)

        findViewById<Button>(R.id.btnWeb).setOnClickListener {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btnSoporte).setOnClickListener {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.btnVolver).setOnClickListener {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }

    // ===== MODO COMPOSE =====
    private fun initCompose() {
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AboutScreenCompose()
                }
            }
        }
    }
}

// UI Compose equivalente
@Composable
fun AboutScreenCompose() {
    val ctx = LocalContext.current
    val msg = stringResource(id = R.string.toast_pendiente)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.autor_texto),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(12.dp))

        // Cambia el nombre si tu drawable no es 'carlosalfredo'
        Image(
            painter = painterResource(id = R.drawable.carlosalfredo),
            contentDescription = stringResource(id = R.string.autor_texto),
            modifier = Modifier
                .width(180.dp)
                .height(180.dp)
        )

        Spacer(Modifier.height(24.dp))

        M3Button(
            onClick = { Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show() },
            modifier = Modifier.fillMaxWidth()
        ) { Text(text = stringResource(id = R.string.btn_web)) }

        Spacer(Modifier.height(12.dp))

        M3Button(
            onClick = { Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show() },
            modifier = Modifier.fillMaxWidth()
        ) { Text(text = stringResource(id = R.string.btn_soporte)) }

        Spacer(Modifier.height(12.dp))

        M3Button(
            onClick = { Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show() },
            modifier = Modifier.fillMaxWidth()
        ) { Text(text = stringResource(id = R.string.btn_volver)) }
    }
}
