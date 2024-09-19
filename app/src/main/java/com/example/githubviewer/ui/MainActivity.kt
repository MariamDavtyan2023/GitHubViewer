package com.example.githubviewer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.githubviewer.R
import com.example.githubviewer.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_graph) as NavHostFragment
//        val navController = navHostFragment.navController
    }
}