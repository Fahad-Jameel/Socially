package com.example.campusride

import android.content.Intent
import android.view.View
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.campusride.databinding.ActivityChatsBinding

class ChatsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener { finish() }

        configureItems()
        setupBottomNav()

        binding.newChatButton.setOnClickListener {
            // TODO compose new chat
        }
        binding.chatSosButton.setOnClickListener {
            // TODO SOS action
        }
    }

    private fun configureItems() {
        binding.chatItem1.chatName.text = getString(R.string.chats_contact_1)
        binding.chatItem1.chatTime.text = getString(R.string.chats_contact_1_time)
        binding.chatItem1.chatMessage.text = getString(R.string.chats_contact_1_message)
        binding.chatItem1.chatBadge.text = getString(R.string.chats_contact_unread)
        binding.chatItem1.root.setOnClickListener {
            startActivity(Intent(this, ChatDetailActivity::class.java))
        }

        binding.chatItem2.chatName.text = getString(R.string.chats_contact_2)
        binding.chatItem2.chatTime.text = getString(R.string.chats_contact_2_time)
        binding.chatItem2.chatMessage.text = getString(R.string.chats_contact_2_message)
        binding.chatItem2.chatBadge.visibility = View.GONE

        binding.chatItem3.chatName.text = getString(R.string.chats_contact_3)
        binding.chatItem3.chatTime.text = getString(R.string.chats_contact_3_time)
        binding.chatItem3.chatMessage.text = getString(R.string.chats_contact_3_message)
        binding.chatItem3.chatBadge.visibility = View.GONE

        binding.chatItem4.chatName.text = getString(R.string.chats_contact_4)
        binding.chatItem4.chatTime.text = getString(R.string.chats_contact_3_time)
        binding.chatItem4.chatMessage.text = getString(R.string.chats_contact_4_message)
        binding.chatItem4.chatBadge.visibility = View.GONE
    }

    private fun setupBottomNav() {
        binding.bottomNav.selectedItemId = R.id.nav_chat
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
                R.id.nav_chat -> true
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}

