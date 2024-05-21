package com.palash.interpolator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.BounceInterpolator
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.button)
        imageView = findViewById<ImageView>(R.id.imageView)
        btn.setOnClickListener {
            animateImageView()
        }
    }

    private fun animateImageView() {
        imageView!!.animate()
            .translationYBy(500f)
            .setDuration(1000)
            .setInterpolator(BounceInterpolator())
            .withEndAction {
                imageView!!.animate()
                    .translationYBy(-500f)
                    .setDuration(1000)
                    .setInterpolator(AccelerateDecelerateInterpolator())
                    .start()
            }
            .start()
    }
}