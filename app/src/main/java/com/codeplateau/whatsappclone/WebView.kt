package com.codeplateau.whatsappclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WebView : AppCompatActivity() {

    //private val URL = "http://whatsapp.com"
    //private var isAlreadyCreated = "false"

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)


        webView = findViewById(R.id.webview)





    }
}
