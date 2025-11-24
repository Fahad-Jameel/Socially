package com.example.campusride

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.campusride.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener { finish() }
        binding.settingsButton.setOnClickListener {
            // TODO settings
        }

        binding.quickOfferButton.setOnClickListener {
            startActivity(Intent(this, OfferRideActivity::class.java))
        }
        binding.quickFindButton.setOnClickListener {
            startActivity(Intent(this, FindRideActivity::class.java))
        }
        binding.editProfileButton.setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
        }
        binding.logoutButton.setOnClickListener {
            // TODO log out
        }

        configureDetailItems()
        configurePreferenceItems()
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

    private fun configureDetailItems() {
        binding.profileEmailRow.detailIcon.setImageResource(R.drawable.ic_mail)
        binding.profileEmailRow.detailTitle.text = getString(R.string.profile_email_label)
        binding.profileEmailRow.detailSubtitle.text = getString(R.string.profile_email_value)

        binding.profilePhoneRow.detailIcon.setImageResource(R.drawable.ic_phone)
        binding.profilePhoneRow.detailTitle.text = getString(R.string.profile_phone_label)
        binding.profilePhoneRow.detailSubtitle.text = getString(R.string.profile_phone_value)

        binding.profileSafetyRow.detailIcon.setImageResource(R.drawable.ic_shield_info)
        binding.profileSafetyRow.detailTitle.text = getString(R.string.profile_safety_label)
        binding.profileSafetyRow.detailSubtitle.text = getString(R.string.profile_safety_value)

        binding.profilePaymentRow.detailIcon.setImageResource(R.drawable.ic_payment)
        binding.profilePaymentRow.detailTitle.text = getString(R.string.profile_payment_label)
        binding.profilePaymentRow.detailSubtitle.text = getString(R.string.profile_payment_value)
    }

    private fun configurePreferenceItems() {
        binding.profileMusicRow.prefIcon.setImageResource(R.drawable.ic_music)
        binding.profileMusicRow.prefTitle.text = getString(R.string.profile_preferences_music_label)
        binding.profileMusicRow.prefSubtitle.text = getString(R.string.profile_preferences_music_value)

        binding.profileFoodRow.prefIcon.setImageResource(R.drawable.ic_food)
        binding.profileFoodRow.prefTitle.text = getString(R.string.profile_preferences_food_label)
        binding.profileFoodRow.prefSubtitle.text = getString(R.string.profile_preferences_food_value)

        binding.profileNotificationsRow.prefIcon.setImageResource(R.drawable.ic_notifications)
        binding.profileNotificationsRow.prefTitle.text = getString(R.string.profile_preferences_notifications_label)
        binding.profileNotificationsRow.prefSubtitle.text = getString(R.string.profile_preferences_notifications_value)
    }
}


