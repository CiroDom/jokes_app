package co.tiagoaguiar.tutorial.jokerappdev.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private lateinit var navController: NavController
  private lateinit var appBarConfig: AppBarConfiguration

  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()

    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val toolbar = binding.mainArea.appbarLayout.toolbar
    setSupportActionBar(toolbar)

    val drawerLayout = binding.drawerLayout

    appBarConfig = AppBarConfiguration(
      setOf(
        R.id.nav_home, R.id.nav_day_joke, R.id.nav_about
      ),
      drawerLayout
    )

    navController = findNavController(R.id.frag_host_main_content)
    setupActionBarWithNavController(navController, appBarConfig)

    val navView = binding.navView
    navView.setupWithNavController(navController)
  }

  override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp() || super.onSupportNavigateUp()
  }
}