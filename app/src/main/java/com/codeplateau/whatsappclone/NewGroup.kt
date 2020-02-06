package com.codeplateau.whatsappclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NewGroup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_group)
        val actionBar = supportActionBar
        actionBar!!.title = "New Group"
        actionBar.setDefaultDisplayHomeAsUpEnabled(true)
        actionBar.setDefaultDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
