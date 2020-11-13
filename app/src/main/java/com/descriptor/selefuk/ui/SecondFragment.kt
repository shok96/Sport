package com.descriptor.selefuk.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.descriptor.selefuk.R

import com.descriptor.selefuk.presenter.Presenter
import com.descriptor.selefuk.presenter.PresenterImpl

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), MainText {
    lateinit var root: View
    lateinit var presenter: Presenter
    lateinit var text: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        root = view
        init()
    }

    override fun setupText(text: String) {
        this.text.text = text
    }

    override fun bind() {
        text = root.findViewById(R.id.text)
    }

    override fun setup() {
        presenter = PresenterImpl(textView = this, context = activity)
        presenter.getText(arguments?.getString("file") ?: "")
    }

    override fun init() {
        bind()
        setup()
    }
}