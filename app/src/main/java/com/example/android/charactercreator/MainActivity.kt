package com.example.android.charactercreator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.charactercreator.stats.CharacterStatsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.stats_fragment, CharacterStatsFragment())
            .commit()
    }
}
