package com.test.msealbums

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

internal class AlbumAdapter(private val dataList: List<Album>) : RecyclerView.Adapter<AlbumAdapter.CustomViewHolder>() {


    internal inner class CustomViewHolder(val myView: View) : RecyclerView.ViewHolder(myView) {

        var textUser: TextView

        init {

            textUser = myView.findViewById(R.id.tv_album_name)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.row_layout, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.textUser.text = dataList[position].album
    }


    override fun getItemCount(): Int {
        return dataList.size
    }
}
