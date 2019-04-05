package com.sandeep.dice

import android.app.PendingIntent
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_starting.*

class Starting : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starting)
        next.setOnClickListener {
            val name: String = enterName.text.toString()
            val intent = Intent(this@Starting, MainActivity::class.java)
            intent.putExtra("nameUser", name)
            Log.d("Name", "user:$name")
            startActivity(intent)


        }
    }
}
