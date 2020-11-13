package com.descriptor.selefuk.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.descriptor.selefuk.R
import com.descriptor.selefuk.model.Data


/**
 * Created by Poma on 24.11.2017.
 */

class ListAdapterImpl(val posts: List<Data.GroupItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_rec, parent, false)
            return TitleViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
                val data: Data.GroupItem = posts.get(position) as Data.GroupItem
                val THolder = holder as TitleViewHolder
                THolder.t1.text = data.group.get(0).title.replace(".txt","")
                THolder.t1.setOnClickListener{
                    val b: Bundle = Bundle()
                    b.putString("file", data.group.get(0).title)
                    Navigation.findNavController(it)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, b)
        }
        THolder.t2.text = data.group.get(1).title.replace(".txt","")
        THolder.t2.setOnClickListener{
            val b: Bundle = Bundle()
            b.putString("file", data.group.get(1).title)
            Navigation.findNavController(it)
                .navigate(R.id.action_FirstFragment_to_SecondFragment, b)
        }


    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }


    override fun getItemCount(): Int {
        if (posts == null)
            return 0
        return posts.size
    }


    class TitleViewHolder: RecyclerView.ViewHolder {

        val t1: TextView
        val t2: TextView

        constructor(itemView: View): super(itemView) {
            t1 = itemView.findViewById(R.id.t1)
            t2 = itemView.findViewById(R.id.t2)
        }
    }
}