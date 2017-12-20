package com.lixinxin.kotlinforandroid.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.lixinxin.kotlinforandroid.R
import com.lixinxin.kotlinforandroid.ui.fragment.FindFragment
import com.lixinxin.kotlinforandroid.ui.fragment.HomeFragment
import com.lixinxin.kotlinforandroid.ui.fragment.HotFragment
import com.lixinxin.kotlinforandroid.ui.fragment.MyFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    var homeFragment: HomeFragment? = null
    var myFragment: MyFragment? = null
    var findFragment: FindFragment? = null
    var hotFragment: HotFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initFragment(savedInstanceState)

        rg.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.rb1 -> {
                    supportFragmentManager.beginTransaction()
                            .show(homeFragment)
                            .hide(myFragment)
                            .hide(findFragment)
                            .hide(hotFragment)
                            .commit()
                }
                R.id.rb2 -> {
                    supportFragmentManager.beginTransaction()
                            .show(findFragment)
                            .hide(homeFragment)
                            .hide(myFragment)
                            .hide(hotFragment)
                            .commit()
                }
                R.id.rb3 -> {
                    supportFragmentManager.beginTransaction()
                            .show(hotFragment)
                            .hide(homeFragment)
                            .hide(myFragment)
                            .hide(findFragment)
                            .commit()
                }
                R.id.rb4 -> {
                    supportFragmentManager.beginTransaction()
                            .show(myFragment)
                            .hide(homeFragment)
                            .hide(hotFragment)
                            .hide(findFragment)
                            .commit()
                }
            }
        }
    }


    private fun initFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            //异常情况
            val mFragments: List<Fragment> = supportFragmentManager.fragments
            for (item in mFragments) {
                if (item is HomeFragment) {
                    homeFragment = item
                }
                if (item is FindFragment) {
                    findFragment = item
                }
                if (item is HotFragment) {
                    hotFragment = item
                }
                if (item is MyFragment) {
                    myFragment = item
                }
            }
        } else {
            homeFragment = HomeFragment()
            myFragment = MyFragment()
            findFragment = FindFragment()
            hotFragment = HotFragment()
            val fragmentTrans = supportFragmentManager.beginTransaction()
            fragmentTrans.add(R.id.fl_context, homeFragment)
            fragmentTrans.add(R.id.fl_context, findFragment)
            fragmentTrans.add(R.id.fl_context, hotFragment)
            fragmentTrans.add(R.id.fl_context, myFragment)
            fragmentTrans.commit()
        }

        rb1.isChecked = true
        supportFragmentManager.beginTransaction()
                .show(homeFragment)
                .hide(findFragment)
                .hide(hotFragment)
                .hide(myFragment)
                .commit()
    }
}
