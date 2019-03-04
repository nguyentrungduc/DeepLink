package com.example.deeplink

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (intent.data != null) {
            findViewById<TextView>(R.id.tv).text = intent.data.getQueryParameter("x") + intent.data.getQueryParameter("y")
        }


    }
}
