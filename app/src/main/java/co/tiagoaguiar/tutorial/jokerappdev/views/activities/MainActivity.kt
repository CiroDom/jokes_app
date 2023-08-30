package co.tiagoaguiar.tutorial.jokerappdev.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private val binding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
  }
  private val navController by lazy {
    findNavController(R.id.frag_host_main_content)
  }
  private lateinit var appBarConfig: AppBarConfiguration

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    installSplashScreen()

    setContentView(binding.root)

    val toolbar = binding.mainArea.appbarLayout.toolbar
    setSupportActionBar(toolbar)

    val drawerLayout = binding.drawerLayout
    val navView = binding.navView

    appBarConfig = AppBarConfiguration(
      setOf(
        R.id.nav_home, R.id.nav_day_joke, R.id.nav_about
      ),
      drawerLayout
    )

    setupActionBarWithNavController(navController, appBarConfig)
    navView.setupWithNavController(navController)
  }

  override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp() || super.onSupportNavigateUp()
  }
}