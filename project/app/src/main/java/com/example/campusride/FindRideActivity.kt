package com.example.campusride

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.campusride.databinding.ActivityFindRideBinding

class FindRideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFindRideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFindRideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener { finish() }

        binding.searchRidesButton.setOnClickListener {
            // TODO hook to search flow
        }

        binding.sosButton.setOnClickListener {
            // TODO hook to SOS flow
        }

        setupBottomNav()
        populateRides()
    }

    private fun setupBottomNav() {
        binding.bottomNav.selectedItemId = R.id.nav_find
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
                R.id.nav_find -> true
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

    private fun populateRides() {
        binding.findRideCard1.rideRoute.text = getString(R.string.sample_ride_route_1)
        binding.findRideCard1.rideDetails.text = getString(R.string.sample_ride_details_1)
        binding.findRideCard1.ridePrice.text = getString(R.string.sample_ride_price_1)
        binding.findRideCard1.rideAvatar.setImageResource(R.drawable.ic_profile_circle_placeholder)

        binding.findRideCard2.rideRoute.text = getString(R.string.sample_ride_route_2)
        binding.findRideCard2.rideDetails.text = getString(R.string.sample_ride_details_2)
        binding.findRideCard2.ridePrice.text = getString(R.string.sample_ride_price_2)

        binding.findRideCard3.rideRoute.text = getString(R.string.sample_ride_route_3)
        binding.findRideCard3.rideDetails.text = getString(R.string.sample_ride_details_3)
        binding.findRideCard3.ridePrice.text = getString(R.string.sample_ride_price_3)
    }
}
