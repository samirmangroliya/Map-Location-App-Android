package com.zt.mylocation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.zt.mylocation.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            try {
                val intent = Intent(this@SplashActivity, WebMapActivity::class.java)
                startActivity(intent)
                this.finish()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }, 3000)
    }

}