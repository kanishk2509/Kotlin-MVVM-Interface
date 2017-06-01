package com.kanishk.prototypes.mvvm_sample.View.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kanishk.prototypes.mvvm_sample.Bus.Event.PostEvent
import com.kanishk.prototypes.mvvm_sample.Bus.EventModel.PostEventModel
import com.kanishk.prototypes.mvvm_sample.Data.PostDataManager

import com.kanishk.prototypes.mvvm_sample.R
import com.kanishk.prototypes.mvvm_sample.View.adapter.PostAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), PostEvent {

    private var mListener: OnFragmentInteractionListener? = null
    private var adapter: PostAdapter? = null

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater!!.inflate(R.layout.fragment_main, container, false)
        setupRecyclerView()
        PostDataManager.getPosts(context, this)
        return v
    }

    private fun setupRecyclerView() {
        recycler_view!!.setHasFixedSize(true)
        recycler_view!!.layoutManager = LinearLayoutManager(context)
        recycler_view!!.itemAnimator = DefaultItemAnimator()
        recycler_view!!.isNestedScrollingEnabled = false
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context as OnFragmentInteractionListener?
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    override fun onDataReceived(eventModel: PostEventModel) {
        Toast.makeText(context, "hello " + eventModel.toString(), Toast.LENGTH_SHORT).show()
        adapter = PostAdapter(context, eventModel.posts)
        recycler_view!!.adapter = adapter
        Toast.makeText(context, "New data incoming!", Toast.LENGTH_SHORT).show()
    }

    override fun onDataUpdate(eventModel: PostEventModel) {
        adapter!!.addNewPost(eventModel.posts[0])
        recycler_view!!.smoothScrollToPosition(0)
    }
}
