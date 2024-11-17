package com.suhazri.lab05

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.suhazri.lab05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ActivityMain => Reverse of our Activity name (MainActivity)
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) // Initialize binding object
        val view = binding.root // Initialize binding object
        setContentView(view)

        binding.orderbtn.setOnClickListener {
            var pizzaSizePrice = 0.0;
            var toppingsPrice = 0.0;

            when {
                binding.smallradiobtn.isChecked -> pizzaSizePrice = 5.0;
                binding.mediumradiobtn.isChecked -> pizzaSizePrice = 7.0;
                binding.largeradiobtn.isChecked -> pizzaSizePrice = 10.0;
            }

            if (binding.onionbox.isChecked) {toppingsPrice += 1.0;}
            if (binding.olivesbox.isChecked) {toppingsPrice += 2.0;}
            if (binding.tomatobox.isChecked) {toppingsPrice += 3.0;}

            if (binding.smallradiobtn.isChecked == false && binding.mediumradiobtn.isChecked== false && binding.largeradiobtn.isChecked== false) {
                binding.totalprice.text = "Please select a size";
            }
            else {
                val totalPrice = pizzaSizePrice + toppingsPrice;
                binding.totalprice.text = "Total Price is: RM ${totalPrice.toString()}";
            }

        }

    }
}