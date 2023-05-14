package com.example.navigationdrawer

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.example.navigationdrawer.fragments.favoriteFragment
import com.example.navigationdrawer.fragments.homeFragment
import com.example.navigationdrawer.fragments.settingsFragment
import com.example.navigationdrawer.ui.theme.NavigationDrawerTheme

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = homeFragment()
        val favoriteFragment = favoriteFragment()
        val settingsFragment = settingsFragment()

        makeCurrentFragment(homeFragment)


          bottom_navigation.setOnNavigationItemSelectedListener{
              when(it.itemId){
                  R.id.ic_home -> makeCurrentFragment(homeFragment)
                  R.id.ic_favorite -> makeCurrentFragment(favoriteFragment)
                  R.id.ic_settings -> makeCurrentFragment(settingsFragment)
              }
              true
          }
    }

    private fun makeCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fl_wrapper, fragment)
        commit()
    }

}