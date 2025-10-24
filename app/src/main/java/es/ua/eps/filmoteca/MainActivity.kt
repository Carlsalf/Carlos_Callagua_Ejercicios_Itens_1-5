package es.ua.eps.filmoteca

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)   // <-- ... botón

        // (opcional) ajuste de insets si tu root tiene id @id/main
        findViewById<android.view.View?>(R.id.main)?.let { root ->
            ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
                val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
                insets
            }
        }

        // Botón About (Ejercicio 2)
        findViewById<Button>(R.id.btnAbout).setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        // Botón Lista XML (Ejercicio 3) – opcional
        findViewById<Button?>(R.id.btnListaXml)?.setOnClickListener {
            startActivity(Intent(this, FilmListActivity::class.java))
        }

        // Botón Lista Compose (Ejercicio 5)
        findViewById<Button>(R.id.btnListaCompose).setOnClickListener {
            startActivity(Intent(this, FilmListComposeActivity::class.java))
        }
    }

    // Menú (Ejercicio 4)
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_about -> { startActivity(Intent(this, AboutActivity::class.java)); true }
        R.id.action_web -> { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Carlsalf"))); true }
        R.id.action_share -> {
            val i = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"; putExtra(Intent.EXTRA_TEXT, "Prueba la app Filmoteca ")
            }
            startActivity(Intent.createChooser(i, "Compartir vía")); true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
