package com.cs473

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cs473.databinding.ActivityMainBinding
import com.cs473.databinding.ActivityRegisterBinding
import com.cs473.model.User

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createAccButton.setOnClickListener {
            val firstName = binding.firstNameEdt.text.toString()
            val lastName  = binding.lastNameEdt.text.toString()
            val email     = binding.emailEdt.text.toString()
            val password  = binding.passwordEdt.text.toString()
            if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val user = User(firstName, lastName, email, password)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }
}