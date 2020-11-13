package com.descriptor.selefuk.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.descriptor.selefuk.R
import com.descriptor.selefuk.model.Data

import com.descriptor.selefuk.presenter.Presenter
import com.descriptor.selefuk.presenter.PresenterImpl

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), MainList {
    lateinit var root: View
    lateinit var presenter: Presenter
    lateinit var rec: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        root = view
        init()
    }

    override fun setupAdapter(list: MutableList<Data.GroupItem>) {
        rec.adapter = ListAdapterImpl(list)
    }

    override fun bind() {
        rec = root.findViewById(R.id.rec)
    }

    override fun setup() {
        presenter = PresenterImpl(listView = this, context = activity)
        rec.layoutManager = LinearLayoutManager(context)
        presenter.getAdapter()
    }

    override fun init() {
        bind()
        setup()
    }
}