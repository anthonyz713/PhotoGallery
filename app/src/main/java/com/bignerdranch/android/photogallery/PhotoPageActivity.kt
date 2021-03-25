package com.bignerdranch.android.photogallery

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PhotoPageActivity : AppCompatActivity() {

    private lateinit var photoPageFragement: PhotoPageFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_page)
        val fm = supportFragmentManager
        val currentFragment = fm.findFragmentById(R.id.fragment_container)
        photoPageFragement = PhotoPageFragment.newInstance(intent.data!!)
        if (currentFragment == null) {
            val fragment = photoPageFragement
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }
    }

    override fun onBackPressed() {
        if(!photoPageFragement.webViewGoBack())
            super.onBackPressed()
    }

    companion object {
        fun newIntent(context: Context, photoPageUri: Uri): Intent {
            return Intent(context, PhotoPageActivity::class.java).apply {
                data = photoPageUri
            }
        }
    }
}