package com.example.goatgaming.ui.login.registration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.goatgaming.MainActivity
import com.example.goatgaming.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class Registration : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding
    //private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener {

            val username = binding.username.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password1.text.toString()
        if ((email.isNotEmpty() || username.isNotEmpty()) && password.isNotEmpty()) {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            Log.d("Login Activity","Failed login")
        }}
        //firebaseAuth = FirebaseAuth.getInstance()


                           // val intent = Intent(this, SignInActivity::class.java)
                            //startActivity(intent)


    }
}