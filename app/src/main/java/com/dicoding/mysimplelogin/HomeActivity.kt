package com.dicoding.mysimplelogin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.mysimplelogin.databinding.ActivityHomeBinding
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    @Inject
    lateinit var userRepository: UserRepository // injected by Dagger. need to be public

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this) // inject dependencies to current class
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvWelcome.text = "Welcome ${userRepository.getUser()}"

        binding.btnLogout.setOnClickListener {
            userRepository.logoutUser()
            moveToMainActivity()
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
