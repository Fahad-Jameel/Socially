package com.example.campusride

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.campusride.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAccountBinding
    private var isPasswordVisible = false
    private var isConfirmPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.backButton.setOnClickListener {
            finish()
        }

        binding.signInLink.setOnClickListener {
            finish()
        }

        binding.createAccountButton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        binding.passwordToggle.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            togglePasswordField(binding.passwordInput, binding.passwordToggle, isPasswordVisible)
        }

        binding.confirmPasswordToggle.setOnClickListener {
            isConfirmPasswordVisible = !isConfirmPasswordVisible
            togglePasswordField(binding.confirmPasswordInput, binding.confirmPasswordToggle, isConfirmPasswordVisible)
        }
    }

    private fun togglePasswordField(
        input: android.widget.EditText,
        toggleView: android.widget.TextView,
        visible: Boolean
    ) {
        if (visible) {
            input.transformationMethod = null
            toggleView.text = getString(R.string.login_toggle_hide)
        } else {
            input.transformationMethod = PasswordTransformationMethod.getInstance()
            toggleView.text = getString(R.string.login_toggle_show)
        }
        input.setSelection(input.text?.length ?: 0)
    }
}

