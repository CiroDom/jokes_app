package co.tiagoaguiar.tutorial.jokerappdev.activities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private val binding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    val toolbar = binding.mainArea.toolbar
    setSupportActionBar(toolbar)

    val drawerLayout = binding.drawerLayout
    val navView = binding.navView
    val navController = findNavController(R.id.frag_host_main_content)
  }
}