package com.codeplateau.whatsappclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//
//
//
//
//        val toggle = ActionBarDrawerToggle(
//            this, drawerLayout, toolbar, R.string.app_name, 0
//        )




    }
    //Created a menu inflater
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.mainmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {

        R.id.menu_newgroup -> {
            newgroup()
            true
        }
        R.id.menu_profile->{
            profile()
            true
        }



        else -> {
            super.onOptionsItemSelected(item)
        }

    }
    fun newgroup(){
        val toProfile = Intent(this,NewGroup::class.java)
        toProfile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(toProfile)
    }
    fun profile(){
        val toProfile = Intent(this,Profile::class.java)
        toProfile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(toProfile)
    }
}
