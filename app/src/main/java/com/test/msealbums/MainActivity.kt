package com.test.msealbums

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Collections


class MainActivity : AppCompatActivity() {

    private var myAdapter: AlbumAdapter? = null
    private var myRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitClient.retrofitInstance!!.create(GetData::class.java)
        val call = service.allUsers
        call.enqueue(object : Callback<List<Album>> {

            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {

                loadDataList(response.body())
            }

            override fun onFailure(call: Call<List<Album>>, throwable: Throwable) {
                Toast.makeText(this@MainActivity, "Unable to load users", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun loadDataList(usersList: List<Album>?) {
        Collections.sort(usersList) { o1, o2 -> o1.album!!.compareTo(o2.album!!) }

        myRecyclerView = findViewById(R.id.rv_album)
        myAdapter = usersList?.let(::AlbumAdapter)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        myRecyclerView!!.layoutManager = layoutManager
        myRecyclerView!!.adapter = myAdapter
    }
}
