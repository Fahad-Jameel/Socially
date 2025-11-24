package com.example.campusride

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.campusride.databinding.ActivityOfferRideBinding

class OfferRideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOfferRideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOfferRideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener { finish() }

        binding.postRideButton.setOnClickListener {
            // TODO: submit ride
        }

        binding.offerSosButton.setOnClickListener {
            // TODO: SOS action
        }

        setupBottomNav()
    }

    private fun setupBottomNav() {
        binding.bottomNav.selectedItemId = R.id.nav_offer
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_offer -> true
                R.id.nav_find -> {
                    startActivity(Intent(this, FindRideActivity::class.java))
                    true
                }
                R.id.nav_chat -> {
                    startActivity(Intent(this, ChatsActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}


