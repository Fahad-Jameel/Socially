package com.example.campusride

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.campusride.databinding.ActivityAddVehicleBinding

class AddVehicleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddVehicleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddVehicleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener { finish() }
        binding.cancelButton.setOnClickListener { finish() }
        binding.saveVehicleButton.setOnClickListener { finish() }

        setupBottomNav()
    }

    private fun setupBottomNav() {
        binding.bottomNav.selectedItemId = R.id.nav_profile
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_offer -> {
                    startActivity(Intent(this, OfferRideActivity::class.java))
                    true
                }
                R.id.nav_find -> {
                    startActivity(Intent(this, FindRideActivity::class.java))
                    true
                }
                R.id.nav_chat -> {
                    startActivity(Intent(this, ChatsActivity::class.java))
                    true
                }
                R.id.nav_profile -> true
                else -> false
            }
        }
    }
}


