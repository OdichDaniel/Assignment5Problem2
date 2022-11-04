package com.cs473

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cs473.databinding.ActivityMainBinding
import com.cs473.model.Product
import com.cs473.model.User
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private val users = mutableListOf(
        User("john", "doe","john@email.com", "0000"),
        User("jane", "doe","jane@email.com", "0001"),
        User("alex", "doe","alex@email.com", "0002"),
        User("peter", "doe","peter@email.com", "0003"),
        User("mary", "doe","mary@email.com", "0004")
    )

    private val products = arrayListOf(Product("Google Pixel 7\" 16GB Android", R.drawable.pixel_phone, 80.00, "Black", UUID.randomUUID().toString(), "Pixel 7’s dual rear camera system helps you capture memories in stunning 4K color and detail. And with Cinematic Blur, you can now bring incredible quality to your videos."),
        Product("Nikon D6 20 Megapixels Camera", R.drawable.camera, 30.00, "Black", UUID.randomUUID().toString(), "What do professional sports photographers need to succeed? A fast frame rate and uncompromising autofocus are only part of the equation. They need a camera that can capture high-quality images of decisive moments reliably, in almost any situation. And they need to be able to select and deliver those images to the market faster than anyone else. Nikon's new D6 flagship FX-format D-SLR camera gives them exactly that, combining a new, higher-density AF system and EXPEED 6 image-processing engine with improved post-shooting workflow and the proven ruggedness of the D5. Wherever the game takes you, the D6 will keep you in the lead."),
        Product("HP Pavilion Laptop - 15t-eg200 Laptop", R.drawable.hp_laptop, 120.00, "Gray", UUID.randomUUID().toString(), "Product(\"Google Pixel 7\\\" 16GB Android\", R.drawable.food, 80.00, \"Black\", UUID.randomUUID().toString(), \"Pixel 7’s dual rear camera system helps you capture memories in stunning 4K color and detail. And with Cinematic Blur, you can now bring incredible quality to your videos"),
        Product("Google Pixel 7\" 16GB Android", R.drawable.pixel_phone, 80.00, "Black", UUID.randomUUID().toString(), "Pixel 7’s dual rear camera system helps you capture memories in stunning 4K color and detail. And with Cinematic Blur, you can now bring incredible quality to your videos."),
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
                    intent.putParcelableArrayListExtra("products", products)
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
                Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show()
            }
        }

        val user = intent.getSerializableExtra("user") as User?
        user?.let {
            users.add(it)
        }
    }
}