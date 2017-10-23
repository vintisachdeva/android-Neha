package com.bmpl.tablayout

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.bmpl.tablayout.R.id.tabLayout
import com.bmpl.tablayout.R.id.viewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById(viewPager) as ViewPager

        val tabLayout = findViewById(tabLayout) as TabLayout

        tabLayout.setupWithViewPager(viewPager)
        setUpPages()

    }

    private fun setUpPages(){

    }
}
