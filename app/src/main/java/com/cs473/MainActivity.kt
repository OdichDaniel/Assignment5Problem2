package com.cs473

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cs473.databinding.ActivityMainBinding
import com.cs473.model.User

class MainActivity : AppCompatActivity() {

    private val users = mutableListOf(
        User("john", "doe","john@email.com", "0000"),
        User("jane", "doe","jane@email.com", "0001"),
        User("alex", "doe","alex@email.com", "0002"),
        User("peter", "doe","peter@email.com", "0003"),
        User("mary", "doe","mary@email.com", "0004")
    )

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInButton.setOnClickListener {
            val username = binding.usernameEdt.text.toString()
            val password = binding.passwordEdt.text.toString()
            for(user in users){
                if(user.username == username && user.password == password){
                    val intent  = Intent(this, ShoppingCategory::class.java)
                    intent.putExtra("username", user.username)
                    startActivity(intent)
                    break;
                }
            }
            Toast.makeText(this, "Username or password is incorrect", Toast.LENGTH_SHORT).show()
        }

        binding.createAccButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.forgotPasswordLink.setOnClickListener {
            val email  = binding.usernameEdt.text.toString()
            for(user in users){
                if(user.username == email){
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "*/*"
                        putExtra(Intent.EXTRA_EMAIL, arrayOf(user.username))
                        putExtra(Intent.EXTRA_SUBJECT, "Forgot password")
                        putExtra(Intent.EXTRA_TEXT, "Your password is: " + user.password)
                    }
                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(intent)
                    }
                    return@setOnClickListener
                }
            }
            Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
        }

        val user = intent.getSerializableExtra("user") as User?
        user?.let {
            users.add(it)
        }
    }
}