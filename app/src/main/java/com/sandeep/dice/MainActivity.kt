package com.sandeep.dice

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceScreen
import android.support.v4.content.ContextCompat
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.sql.StatementEvent
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var dice_Image: ImageView
    lateinit var emoji_image: ImageView
    private var user:String? = null
    // lateinit var backgroud_Color: RelativeLayout
    // val mainLayout = findViewById<LinearLayout>(R.id.main_layout)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bundle: Bundle? = intent.extras
        user = bundle!!.getString("nameUser")
        val rollButton: Button = findViewById(R.id.rollBtn)
        dice_Image = findViewById(R.id.dice_image)
        emoji_image = findViewById(R.id.emoji_image)
        rollButton.setOnClickListener {
            // rollButton.text = "Button Rolled"
            //  Toast.makeText(this, "Button Rolled", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun rollDice() {
        val ransdomint = Random.nextInt(6) + 1
        userName.text = "Sandeep Dutta Likes $user"
        if (ransdomint > 5) {
            userName.visibility = View.VISIBLE
        } else {
            userName.visibility = View.INVISIBLE
        }
        val drawableResource = when (ransdomint) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val emojidrawableResource = when (ransdomint) {
            1 -> R.drawable.mad
            2 -> R.drawable.unhappy
            3 -> R.drawable.thinking
            4 -> R.drawable.happy
            5 -> R.drawable.love
            else -> R.drawable.kissing
        }
        val background = when (ransdomint) {
            1 -> ContextCompat.getColor(this, R.color.blue)
            2 -> ContextCompat.getColor(this, R.color.green)
            3 -> ContextCompat.getColor(this, R.color.reddish)
            4 -> ContextCompat.getColor(this, R.color.purple)
            5 -> ContextCompat.getColor(this, R.color.orange)
            else -> ContextCompat.getColor(this, R.color.yellow)
        }
        val button_background = when (ransdomint) {
            1 -> ContextCompat.getColor(this, R.color.dark_blue)
            2 -> ContextCompat.getColor(this, R.color.dark_green)
            3 -> ContextCompat.getColor(this, R.color.dark_reddish)
            4 -> ContextCompat.getColor(this, R.color.dark_purple)
            5 -> ContextCompat.getColor(this, R.color.dark_orange)
            else -> ContextCompat.getColor(this, R.color.dark_yellow)
        }
        val comment = when (ransdomint) {
            1 -> "MAD"
            2 -> "Worried"
            3 -> "Thinking"
            4 -> "Happy"
            5 -> "LOVE"
            else -> "Excess Love"
        }
        dice_Image.setImageResource(drawableResource)
        emoji_image.setImageResource(emojidrawableResource)
        rollBtn.setBackgroundColor(button_background)
        main_layout.setBackgroundColor(background)
        tv.text = comment.toUpperCase()
    }


}
