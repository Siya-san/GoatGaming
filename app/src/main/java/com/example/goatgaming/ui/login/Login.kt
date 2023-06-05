package com.example.goatgaming.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.goatgaming.MainActivity
import com.example.goatgaming.databinding.ActivityLoginBinding
import com.example.goatgaming.ui.login.registration.Registration
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private val test_username = "moron"
    private val test_email = "moron1@gmail.com"
    private val test_password = "password"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // firebaseAuth = FirebaseAuth.getInstance()


        binding.login.setOnClickListener {

            val username = binding.username.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if ((email.isNotEmpty() || username.isNotEmpty()) && password.isNotEmpty()) {
                if((email.equals(test_email)&& password.equals(test_password))||(username.equals(test_username)&& password.equals(test_password))){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Log.d("Login Activity","Failed login")
                }

            }
        }
binding.SignUp.setOnClickListener {
    val intent = Intent(this, Registration::class.java)
    startActivity(intent)
}

    }

}