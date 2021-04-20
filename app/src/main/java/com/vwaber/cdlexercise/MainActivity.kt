package com.vwaber.cdlexercise

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.vwaber.cdlexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_requestequipment,
                R.id.navigation_activerentals,
                R.id.navigation_openrequests,
                R.id.navigation_myyard
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.bottomNav.navRequestequipment.setOnClickListener {
            navController.navigate(R.id.navigation_requestequipment)
            setAllInactive()
            setRequestequipmentActive()
        }

        binding.bottomNav.navActiverentals.setOnClickListener {
            navController.navigate(R.id.navigation_activerentals)
            setAllInactive()
            setActiverentalsActive()
        }

        binding.bottomNav.navOpenrequests.setOnClickListener {
            navController.navigate(R.id.navigation_openrequests)
            setAllInactive()
            setOpenrequestsActive()
        }

        binding.bottomNav.navMyyard.setOnClickListener {
            navController.navigate(R.id.navigation_myyard)
            setAllInactive()
            setMyyardActive()
        }

    }

    private fun TextView.setStyle(style: Int) {
        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            this.setTextAppearance(style)
        } else {
            this.setTextAppearance(applicationContext, style)
        }
    }

    private fun setAllInactive() {
        val style = R.style.bottom_nav
        val bottomNav = binding.bottomNav

        val textViews = setOf(
            bottomNav.tvRequestequipment,
            bottomNav.tvActiverentals,
            bottomNav.tvOpenrequests,
            bottomNav.tvMyyard
        )
        for (tv in textViews) {
            tv.setStyle(style)
        }

        val underlines = setOf(
            bottomNav.vUnderlineRequestequipment,
            bottomNav.vUnderlineActiverentals,
            bottomNav.vUnderlineOpenrequests,
            bottomNav.vUnderlineMyyard
        )
        for (underline in underlines) {
            underline.visibility = View.INVISIBLE
        }
    }

    private fun setRequestequipmentActive() {
        binding.bottomNav.tvRequestequipment.setStyle(R.style.bottom_nav_active)
        binding.bottomNav.vUnderlineRequestequipment.visibility = View.VISIBLE
    }

    private fun setActiverentalsActive() {
        binding.bottomNav.tvActiverentals.setStyle(R.style.bottom_nav_active)
        binding.bottomNav.vUnderlineActiverentals.visibility = View.VISIBLE
    }

    private fun setOpenrequestsActive() {
        binding.bottomNav.tvOpenrequests.setStyle(R.style.bottom_nav_active)
        binding.bottomNav.vUnderlineOpenrequests.visibility = View.VISIBLE
    }

    private fun setMyyardActive() {
        binding.bottomNav.tvMyyard.setStyle(R.style.bottom_nav_active)
        binding.bottomNav.vUnderlineMyyard.visibility = View.VISIBLE
    }

}