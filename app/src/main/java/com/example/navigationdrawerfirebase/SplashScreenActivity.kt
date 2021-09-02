package com.example.navigationdrawerfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.navigationdrawerfirebase.databinding.ActivitySignInWithGoogleBinding
import com.example.navigationdrawerfirebase.databinding.ActivitySplashScreenBinding
import com.google.firebase.auth.FirebaseAuth

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        supportActionBar?.hide()
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            if (user == null){
                val intenting = Intent(this@SplashScreenActivity,SignInWIthGoogle::class.java)
                startActivity(intenting)
                finish()
            }else{
                val intenting = Intent(this@SplashScreenActivity,MainActivity::class.java)
                startActivity(intenting)
                finish()
            }
        },3000)
    }
}