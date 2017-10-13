package com.bmpl.webview

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.bmpl.webview.R.id.webView

class MainActivity : AppCompatActivity() {

    var url : String = "https://www.google.co.in/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var webView = findViewById(webView) as WebView

        webView.setWebViewClient(CustomClient())
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)

    }

    //inside the app show result when search
    class CustomClient : WebViewClient(){
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            var uri = request!!.url //--> //URI -->
            view!!.loadUrl(uri.toString())
            return true
        }
    }
}
