package com.michael.sendingdatatootheractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.michael.sendingdatatootheractivities.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Getting the intent message from the MainActivity:
        val data = intent.extras
        data?.let {
            val firstName = it.getString(Constants.FIRST_NAME_KEY)
            val lastName = it.getString(Constants.LAST_NAME_KEY)
            val phoneNumber = it.getLong(Constants.PHONE_NUMBER_KEY)

            val myDetails = binding.displayInfo.text
            binding.displayInfo.text =
                "$myDetails \nFirst Name: $firstName \nLast Name: $lastName \nPhone Number: $phoneNumber"
        }

        // Sending intent message to the MainActivity:
        binding.goBackButton.setOnClickListener {
            val intent = intent
            intent.putExtra(Constants.FIRST_NAME_KEY, "Hello, I'm ${Constants.FIRST_NAME_KEY} from the previous activity.")
            setResult(Constants.RESULT_CODE, intent)
            finish()
          /*  Intent(this@SecondActivity, MainActivity::class.java).also {
                startActivity(it)
            }*/
        }

    }
}