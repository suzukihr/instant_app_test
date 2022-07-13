package com.example.sampleapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent

class MainActivity : AppCompatActivity() {

    private val webLink = "https://tsuginavi.com/companies/1172947012251022"

    private val dynamicLink = "https://tsuginavi.page.link/?apn=com.tsuginavi.android.manual&link=$webLink&afl=$webLink"

    private val googlePlayLink = "market://launch?id=com.tsuginavi.android.manual"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button1)?.setOnClickListener {
            openInBrowser(webLink)
        }

        findViewById<Button>(R.id.button2)?.setOnClickListener {
            openInCustomTab(webLink)
        }

        findViewById<Button>(R.id.button3)?.setOnClickListener {
            openInBrowser(dynamicLink)
        }

        findViewById<Button>(R.id.button4)?.setOnClickListener {
            openInCustomTab(dynamicLink)
        }

        findViewById<Button>(R.id.button5)?.setOnClickListener {
            openInBrowser(googlePlayLink)
        }

        findViewById<Button>(R.id.button6)?.setOnClickListener {
            openInCustomTab(googlePlayLink)
        }
    }

    private fun openInBrowser(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }

    private fun openInCustomTab(url: String) {
        // https://developer.chrome.com/docs/android/custom-tabs/integration-guide/
        val customTabsIntent: CustomTabsIntent = CustomTabsIntent.Builder().build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }
}