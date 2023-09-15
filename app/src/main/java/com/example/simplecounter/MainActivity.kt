package com.example.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var counter = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button);
        val text = findViewById<TextView>(R.id.textView);
        button.setOnClickListener {
            counter+=1;
            text.text = counter.toString();
        }

        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)

        button.setOnClickListener {
            counter++
            text.text = counter.toString()
            if (counter >= 100) {
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "Add 2"
                    button.setOnClickListener {
                        counter += 2
                        text.text = counter.toString()
                    }
                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }
    }
}