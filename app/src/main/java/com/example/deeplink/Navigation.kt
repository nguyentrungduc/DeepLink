package com.example.deeplink

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Navigation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        findViewById<TextView>(R.id.tv).text = NavigationArgs.fromBundle(intent.extras).xx
    }
}
