package com.example.goatgaming

import android.content.Context
import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.goatgaming.databinding.ActivityMainBinding
import com.example.goatgaming.ui.booking.Booking
import com.example.goatgaming.ui.booking.BookingAdaptor
import com.example.goatgaming.ui.booking.BookingReviewFragment
import com.example.goatgaming.ui.event.Event
import com.example.goatgaming.ui.event.EventAdaptor
import com.example.goatgaming.ui.event.EventSignUpFragment

class MainActivity : AppCompatActivity(), EventAdaptor.OnItemClickListener,BookingAdaptor.OnItemClickListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_booking,R.id.nav_event,R.id.nav_store,R.id.nav_giveaway, R.id.nav_gallery
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    fun createEvent() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController

        navController.navigate(R.id.nav_create_event, Bundle().apply {

        })
    }
    fun goToCart() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController

        navController.navigate(R.id.cartFragment, Bundle().apply {

        })
    }
    override fun onItemClick(event: Event) {
        val itemFragment = EventSignUpFragment.newInstance(event)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController

        navController.navigate(R.id.nav_event_signup, Bundle().apply {
            putParcelable("arg_event", event)
        })
    }
    override fun onItemClick(booking: Booking) {
        val itemFragment = BookingReviewFragment.newInstance(booking)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController

        navController.navigate(R.id.bookingReviewFragment, Bundle().apply {
            putParcelable("arg_booking", booking)
        })
    }
   
}