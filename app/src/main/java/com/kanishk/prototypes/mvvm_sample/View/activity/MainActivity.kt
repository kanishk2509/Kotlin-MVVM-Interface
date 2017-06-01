package com.kanishk.prototypes.mvvm_sample.View.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.kanishk.prototypes.mvvm_sample.Bus.Event.PostEvent
import com.kanishk.prototypes.mvvm_sample.Bus.EventModel.PostEventModel
import com.kanishk.prototypes.mvvm_sample.Data.PostDataManager
import com.kanishk.prototypes.mvvm_sample.R
import com.kanishk.prototypes.mvvm_sample.View.adapter.PostAdapter
import com.kanishk.prototypes.mvvm_sample.ViewModel.MainActivityViewModel
import com.kanishk.prototypes.mvvm_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), PostEvent {

    private val context = this@MainActivity
    private var recyclerView: RecyclerView? = null
    private var adapter: PostAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBindings()
        setupViews()
        PostDataManager.getPosts(context)
    }

    private fun setupBindings() {
        val mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mainBinding.viewModel = MainActivityViewModel(context)
    }

    private fun setupViews() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        val linear = LinearLayoutManager(context)
        linear.reverseLayout = true
        recyclerView!!.layoutManager = linear
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.isNestedScrollingEnabled = false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return id == R.id.action_settings || super.onOptionsItemSelected(item)
    }

    override fun onDataReceived(eventModel: PostEventModel) {
        adapter = PostAdapter(context, eventModel.posts)
        recyclerView!!.adapter = adapter
        Toast.makeText(context, "New data incoming!", Toast.LENGTH_SHORT).show()
    }

    override fun onDataUpdate(eventModel: PostEventModel) {
        adapter!!.addNewPost(eventModel.posts[0])
        recyclerView!!.smoothScrollToPosition(0)
    }
}
