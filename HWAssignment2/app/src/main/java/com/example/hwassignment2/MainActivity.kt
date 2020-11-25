package com.example.hwassignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var cService : ClaimService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        val fldRowGenerator = ObjDetailScreenGenerator(this)
        val colView = fldRowGenerator.generate()
        setContentView(colView)

        cService = ClaimService.getInstance(this)

        val status : TextView = findViewById(R.id.status)

        val aView : Button = findViewById(R.id.add_btn)

        aView.setOnClickListener {
            var initTitle : EditText = findViewById(R.id.claim_title)
            var initDate : EditText = findViewById(R.id.date)

            var claimTitle = initTitle.text.toString()
            var date = initDate.text.toString()

            if (claimTitle == "") {
                status.text = "Status: Fields cannot be blank."
            }
            else if (date == ""){
                status.text = "Status: Claim ${claimTitle} failed to be created. Please enter date."
            }
            else {
                var cObj = Claim(UUID.randomUUID(), claimTitle, date, false)
                cService.addClaim(cObj)

                initTitle.text.clear()
                initDate.text.clear()
                status.text = "Status: Claim ${claimTitle} was successfully created."
            }
        }
    }
}