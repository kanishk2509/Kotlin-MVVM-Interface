package com.kanishk.prototypes.mvvm_sample.View.activity

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.kanishk.prototypes.mvvm_sample.R
import com.kanishk.prototypes.mvvm_sample.View.fragment.MainFragment
import com.kanishk.prototypes.mvvm_sample.ViewModel.MainActivityViewModel
import com.kanishk.prototypes.mvvm_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainFragment.OnFragmentInteractionListener {

    private val context = this@MainActivity
    private var tabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBindings()
        setupViews()
    }

    private fun setupBindings() {
        val mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mainBinding.viewModel = MainActivityViewModel(context)
    }

    private fun setupViews() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        setupViewPager()
    }

    @SuppressLint("PrivateResource")
    private fun setupViewPager() {
        val pagerAdapter = SectionPagerAdapter()
        val viewPager: ViewPager? = findViewById(R.id.container) as ViewPager
        viewPager?.adapter = pagerAdapter
        viewPager?.offscreenPageLimit = 3
        tabLayout = findViewById(R.id.tabs) as TabLayout?
        tabLayout?.setupWithViewPager(viewPager)
        tabLayout?.setSelectedTabIndicatorHeight(12)
        tabLayout?.setSelectedTabIndicatorColor(context.resources.getColor(R.color.abc_tint_spinner))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return id == R.id.action_settings || super.onOptionsItemSelected(item)
    }

    inner class SectionPagerAdapter : FragmentPagerAdapter(supportFragmentManager) {

        var tabTitles: List<String>? = listOf("hello", "world", "hey")

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return MainFragment.newInstance()
                1 -> return MainFragment.newInstance()
                2 -> return MainFragment.newInstance()
            }
            return MainFragment.newInstance()
        }

        override fun getCount(): Int {
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence {
            return tabTitles!![position]
        }
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
