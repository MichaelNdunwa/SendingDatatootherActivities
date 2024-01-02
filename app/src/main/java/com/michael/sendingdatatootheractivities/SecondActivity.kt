package com.michael.sendingdatatootheractivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.michael.sendingdatatootheractivities.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var activitySecondBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activitySecondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(activitySecondBinding.root)


        val data = intent.extras
        data?.let {
            val firstName = it.getString(Constants.FIRST_NAME_KEY)
            val lastName = it.getString(Constants.LAST_NAME_KEY)
            val phoneNumber = it.getLong(Constants.PHONE_NUMBER_KEY)

            val myDetails = activitySecondBinding.displayInfo.text
            activitySecondBinding.displayInfo.text =
                "$myDetails \nFirst Name: $firstName \nLast Name: $lastName \nPhone Number: $phoneNumber"
        }
    }
}