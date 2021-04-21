package com.vwaber.cdlexercise

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.vwaber.cdlexercise.databinding.ActivityMainBinding

typealias ViewState = MainViewModel.ViewState
typealias Destination = MainViewModel.Destination

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
                .navController

        setupActionBarWithNavController(
            navController, AppBarConfiguration(
                setOf(
                    R.id.navigation_requestequipment,
                    R.id.navigation_activerentals,
                    R.id.navigation_openrequests,
                    R.id.navigation_myyard
                )
            )
        )

        binding.bottomNav.let {
            it.navRequestequipment.setOnClickListener(this)
            it.navActiverentals.setOnClickListener(this)
            it.navOpenrequests.setOnClickListener(this)
            it.navMyyard.setOnClickListener(this)
        }

        mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.viewState.observe(this) { it?.let { render(it) } }

    }

    private fun render(viewState: ViewState) {
        setAllInactive()
        when (viewState.destination) {
            Destination.REQUEST_EQUIPMENT -> setRequestequipmentActive(true)
            Destination.ACTIVE_RENTALS -> setActiverentalsActive(true)
            Destination.OPEN_REQUESTS -> setOpenrequestsActive(true)
            Destination.MY_YARD -> setMyyardActive(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }

    override fun onClick(v: View?) {
        with(binding.bottomNav) {
            when (v) {
                navRequestequipment -> {
                    mainViewModel.setDestination(Destination.REQUEST_EQUIPMENT)
                    navController.navigate(R.id.navigation_requestequipment)
                }
                navActiverentals -> {
                    mainViewModel.setDestination(Destination.ACTIVE_RENTALS)
                    navController.navigate(R.id.navigation_activerentals)
                }
                navOpenrequests -> {
                    mainViewModel.setDestination(Destination.OPEN_REQUESTS)
                    navController.navigate(R.id.navigation_openrequests)
                }
                navMyyard -> {
                    mainViewModel.setDestination(Destination.MY_YARD)
                    navController.navigate(R.id.navigation_myyard)
                }
            }
        }
    }

    private fun setRequestequipmentActive(active: Boolean) {
        binding.bottomNav.tvRequestequipment.setActive(active)
        binding.bottomNav.vUnderlineRequestequipment.setActive(active)
    }

    private fun setActiverentalsActive(active: Boolean) {
        binding.bottomNav.tvActiverentals.setActive(active)
        binding.bottomNav.vUnderlineActiverentals.setActive(active)
    }

    private fun setOpenrequestsActive(active: Boolean) {
        binding.bottomNav.tvOpenrequests.setActive(active)
        binding.bottomNav.vUnderlineOpenrequests.setActive(active)
    }

    private fun setMyyardActive(active: Boolean) {
        binding.bottomNav.tvMyyard.setActive(active)
        binding.bottomNav.vUnderlineMyyard.setActive(active)
    }

    private fun setAllInactive() {
        setRequestequipmentActive(false)
        setActiverentalsActive(false)
        setOpenrequestsActive(false)
        setMyyardActive(false)
    }

    private fun TextView.setActive(active: Boolean) {
        if (active) {
            setStyle(R.style.bottom_nav_active)
        } else {
            setStyle(R.style.bottom_nav)
        }
    }

    private fun View.setActive(active: Boolean) {
        visibility = if (active) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }

    @Suppress("DEPRECATION")
    private fun TextView.setStyle(style: Int) {
        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            this.setTextAppearance(style)
        } else {
            this.setTextAppearance(applicationContext, style)
        }
    }

}
