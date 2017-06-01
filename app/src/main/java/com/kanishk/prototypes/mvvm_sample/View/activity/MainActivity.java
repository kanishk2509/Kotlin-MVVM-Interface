package com.kanishk.prototypes.mvvm_sample.View.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.kanishk.prototypes.mvvm_sample.Bus.Event.PostEvent;
import com.kanishk.prototypes.mvvm_sample.Bus.EventModel.PostEventModel;
import com.kanishk.prototypes.mvvm_sample.Data.PostDataManager;
import com.kanishk.prototypes.mvvm_sample.R;
import com.kanishk.prototypes.mvvm_sample.View.adapter.PostAdapter;
import com.kanishk.prototypes.mvvm_sample.ViewModel.MainActivityViewModel;
import com.kanishk.prototypes.mvvm_sample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements PostEvent {

    private final Context context = MainActivity.this;

    private RecyclerView recyclerView;
    private PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBindings();
        setupViews();
        PostDataManager.getPosts(context);
    }

    private void setupBindings() {
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setViewModel(new MainActivityViewModel(context));
    }

    private void setupViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linear = new LinearLayoutManager(context);
        linear.setReverseLayout(true);
        recyclerView.setLayoutManager(linear);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataReceived(PostEventModel eventModel) {
        adapter = new PostAdapter(context, eventModel.getPosts());
        recyclerView.setAdapter(adapter);
        Toast.makeText(context, "New data incoming!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataUpdate(PostEventModel eventModel) {
        adapter.addNewPost(eventModel.getPosts().get(0));
        recyclerView.smoothScrollToPosition(0);
    }
}
