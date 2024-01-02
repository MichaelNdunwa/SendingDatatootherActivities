package com.michael.sendingdatatootheractivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.michael.sendingdatatootheractivities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Constants.RESULT_CODE) {
                    val message = it.data?.getStringExtra(Constants.FIRST_NAME_KEY)
                    binding.textView.text = message
                }
            }

        // Sending the date to the other activity:
        binding.gotoSecondActivity.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                it.putExtra(Constants.FIRST_NAME_KEY, "Michael")
                it.putExtra(Constants.LAST_NAME_KEY, "Ndunwa")
                it.putExtra(Constants.PHONE_NUMBER_KEY, "07035081328".toLong())
                getResult.launch(it)
//                startActivity(it)
            }
        }

    }
}