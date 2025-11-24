package com.example.campusride

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.campusride.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Future logic for login actions will go here.
        binding.createAccount.setOnClickListener {
            startActivity(Intent(this, CreateAccountActivity::class.java))
        }

        binding.signInButton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        binding.passwordToggle.setOnClickListener {
            togglePasswordVisibility()
        }

        binding.forgotPassword.setOnClickListener {
            // TODO: open forgot password flow
        }
    }

    private fun togglePasswordVisibility() {
        val input = binding.passwordInput
        isPasswordVisible = !isPasswordVisible
        if (isPasswordVisible) {
            input.transformationMethod = null
            binding.passwordToggle.text = getString(R.string.login_toggle_hide)
        } else {
            input.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.passwordToggle.text = getString(R.string.login_toggle_show)
        }
        input.setSelection(input.text?.length ?: 0)
    }
}

