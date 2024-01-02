package com.michael.sendingdatatootheractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.michael.sendingdatatootheractivities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // Sending the date to the other activity:
        activityMainBinding.gotoSecondActivity.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                it.putExtra(Constants.FIRST_NAME_KEY, "Michael")
                it.putExtra(Constants.LAST_NAME_KEY, "Ndunwa")
                it.putExtra(Constants.PHONE_NUMBER_KEY, "07035081328".toLong())
                startActivity(it)
            }
        }
    }
}