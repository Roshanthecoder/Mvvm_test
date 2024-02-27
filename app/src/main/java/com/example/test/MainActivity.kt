package com.example.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.test.adapter.MainAdapter
import com.example.test.databinding.ActivityMainBinding
import com.example.test.models.PostListResponseItem
import com.example.test.network.RetrofitClient
import com.example.test.repository.MainRepository
import com.example.test.viewmodel.MainViewmodel
import com.example.test.viewmodelfactory.MainViewmodelFactory

private lateinit var binding: ActivityMainBinding
private lateinit var mainViewmodel: MainViewmodel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repository = MainRepository(RetrofitClient.apiInterface)
        mainViewmodel =
            ViewModelProvider(this, MainViewmodelFactory(repository))[MainViewmodel::class.java]
        mainViewmodel.getPostList()
        mainViewmodel.postList.observe(this, Observer { itemlist ->
            binding.recyclerView.apply {
                adapter = MainAdapter(itemlist as ArrayList<PostListResponseItem>)
                binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(
                        this@MainActivity,
                        DividerItemDecoration.VERTICAL
                    )
                )
            }
        })

    }
}