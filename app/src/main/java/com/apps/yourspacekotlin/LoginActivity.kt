package com.apps.yourspacekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.apps.yourspacekotlin.NotesApp.NotesListActivity
import com.apps.yourspacekotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this,NotesListActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.textView2.setOnClickListener {
            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}