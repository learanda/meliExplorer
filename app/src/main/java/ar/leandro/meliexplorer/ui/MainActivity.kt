package ar.leandro.meliexplorer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ar.leandro.meliexplorer.R
import ar.leandro.meliexplorer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }


}